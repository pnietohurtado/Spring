package com.pruebaChat.PruebaChat.controller;

import com.pruebaChat.PruebaChat.service.ChatHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    @MessageMapping("/chat1")
    public void getMessage(Message message){
        System.out.println("El mensaje recibido es " + message);
    }
}