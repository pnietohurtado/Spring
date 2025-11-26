package com.pruebaChat.PruebaChat.controller;

import com.pruebaChat.PruebaChat.service.ChatHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatHandler chatHandler;

    @GetMapping
    public String showChatPage() {
        return "chat"; // Esto retornará chat.html (necesitas tener Thymeleaf configurado)
    }

    @GetMapping("/status")
    public ResponseEntity<?> getChatStatus() {
        return ResponseEntity.ok().body("{\"activeUsers\": " + chatHandler.getActiveUsersCount() + "}");
    }
}