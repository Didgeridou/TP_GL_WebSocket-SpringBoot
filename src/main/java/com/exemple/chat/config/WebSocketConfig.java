package com.exemple.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker   // active la gestion des messages WebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 1. Point d'entrée : l'URL où les clients se connectent
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")        // les clients se connectent à ws://.../ws
                .setAllowedOriginPatterns("*")
                .withSockJS();             // repli SockJS si WebSocket indisponible
    }

    // 2. Configuration du broker (qui distribue les messages)
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Destinations vers lesquelles le serveur ENVOIE (les clients s'y abonnent)
        registry.enableSimpleBroker("/topic");

        // Préfixe des destinations que le CLIENT envoie au serveur
        registry.setApplicationDestinationPrefixes("/app");
    }
}