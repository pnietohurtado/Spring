package com.example.WebSockets.endpoint;

import com.example.WebSockets.dto.JoinMessageDTO;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Map;
//import org.springframework.boot.web.embedded.tomcat.TomcatWebServer.TomcatEmbeddedContext.JoinedClassLoader.JoinMessage;

@Controller
public class ChatController {

    public void onJoin( // Básicamente lo que vamos a hacer es mostrar si el usuario se había registrado previamente y darle un mensaje de bienvenida
            @Payload JoinMessageDTO message,
            SimpMessageHeaderAccessor accesor)
    {
        String sesionID = accesor.getSessionId();
        Map<String, Object> sessionAttributes = accesor.getSessionAttributes();
        System.out.println(sesionID);
        System.out.println(sessionAttributes);

        sessionAttributes.put("username", message.username()); 
    }

}
