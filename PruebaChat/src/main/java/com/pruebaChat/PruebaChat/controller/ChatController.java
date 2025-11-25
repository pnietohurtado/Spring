package com.pruebaChat.PruebaChat.controller;

import com.pruebaChat.PruebaChat.service.ChatHandler;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {



    @GetMapping
    public ResponseEntity<String> showChatPage(){
        return ResponseEntity.ok("chat");
    }

}
