package com.example.WebSockets.endpoint;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    public void onJoin(@Payload JoinM message,
                       SimpMessageHeaderAccessor accesor){

    }

}
