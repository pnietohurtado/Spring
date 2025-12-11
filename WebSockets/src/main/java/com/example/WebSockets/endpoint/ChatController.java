package com.example.WebSockets.endpoint;

import com.example.WebSockets.dto.ChatMessageDTO;
import com.example.WebSockets.dto.JoinMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
//import org.springframework.boot.web.embedded.tomcat.TomcatWebServer.TomcatEmbeddedContext.JoinedClassLoader.JoinMessage;

@Controller
public class ChatController {

    @Autowired
    private SimpMessageSendingOperations ops;

    private static final Map<String, Map<String, Object>> sessions = new ConcurrentHashMap<>();


    public void onJoin( // Básicamente lo que vamos a hacer es mostrar si el usuario se había registrado previamente y darle un mensaje de bienvenida
            @Payload JoinMessageDTO message,
            SimpMessageHeaderAccessor accesor)
    {
        String sesionID = accesor.getSessionId();
        Map<String, Object> sessionAttributes = accesor.getSessionAttributes();
        System.out.println(sesionID);
        System.out.println(sessionAttributes);

        //Añadimos dentro del mapa de la clase este mapa de inicio de sesión para tener constancia de los usuarios dentro de la web
        sessions.put(sesionID, sessionAttributes);

        String username = message.username();
        sessionAttributes.put("username", message.username());

        var msg = new ChatMessageDTO(username, username + " joined the chat");
        this.ops.convertAndSend("/topic/responses", msg);

        var userMsg = new ChatMessageDTO(username, getUsername());
        this.ops.convertAndSend("/topic/users", userMsg);
    }

    @MessageMapping("/chat")
    @SendTo("/topic/responses") // Envía mensaje a todas las personas en /responses
    public ChatMessageDTO onMessage(
            @Payload ChatMessageDTO message,
            SimpMessageHeaderAccessor accessor
    ){

        return message;
    }

    private String getUsername(){
        return sessions.values().stream()
                .map(v -> v.get("username"))
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

}
