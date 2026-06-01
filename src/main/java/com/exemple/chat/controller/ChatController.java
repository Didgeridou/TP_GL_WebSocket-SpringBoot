package com.exemple.chat.controller;

import com.exemple.chat.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // Reçoit sur /app/chat.envoyer → rediffuse à tous les abonnés de /topic/public
    @MessageMapping("/chat.envoyer")
    @SendTo("/topic/public")
    public ChatMessage envoyerMessage(@Payload ChatMessage message) {
        return message;   // l'objet retourné est broadcasté à tous
    }

    // Reçoit sur /app/chat.rejoindre → annonce l'arrivée d'un utilisateur
    @MessageMapping("/chat.rejoindre")
    @SendTo("/topic/public")
    public ChatMessage rejoindre(@Payload ChatMessage message) {
        message.setType(ChatMessage.TypeMessage.ARRIVEE);
        message.setContenu(message.getExpediteur() + " a rejoint le chat !");
        return message;
    }
}