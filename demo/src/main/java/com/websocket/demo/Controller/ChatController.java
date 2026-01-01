package com.websocket.demo.Controller;

import com.websocket.demo.Persistance.Models.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages") // Where the message is going to end
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }


    @GetMapping("/chat-page")  // <-- CAMBIADO
    public String chat() {
        return "chat"; // Esto buscará chat.html en templates/
    }

}
