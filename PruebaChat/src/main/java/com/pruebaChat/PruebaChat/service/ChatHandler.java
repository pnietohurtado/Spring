package com.pruebaChat.PruebaChat.service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ChatHandler extends TextWebSocketHandler {

    private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        broadcastSystemMessage("Usuario conectado - Usuarios activos: " + sessions.size());
        System.out.println("Nueva conexión establecida. Total: " + sessions.size());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        broadcastSystemMessage("Usuario desconectado - Usuarios activos: " + sessions.size());
        System.out.println("Conexión cerrada. Total: " + sessions.size());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        String formattedMessage = "[" + getCurrentTime() + "] " + payload;

        System.out.println("Mensaje recibido: " + formattedMessage);
        broadcastMessage(formattedMessage);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.err.println("Error de transporte: " + exception.getMessage());
        sessions.remove(session);
    }

    private void broadcastMessage(String message) {
        sessions.forEach(session -> {
            if (session.isOpen()) {
                try {
                    session.sendMessage(new TextMessage(message));
                } catch (IOException e) {
                    System.err.println("Error enviando mensaje: " + e.getMessage());
                }
            }
        });
    }

    private void broadcastSystemMessage(String message) {
        broadcastMessage("SISTEMA: " + message + " [" + getCurrentTime() + "]");
    }

    private String getCurrentTime() {
        return LocalTime.now().format(TIME_FORMATTER);
    }

    public int getActiveUsersCount() {
        return sessions.size();
    }
}