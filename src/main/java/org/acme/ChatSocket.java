package org.acme;

import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;
import jakarta.inject.Inject;

// https://quarkus.io/guides/websockets
// ./mvnw quarkus:add-extension -Dextensions='websockets'
// ./mvnw quarkus:add-extension -Dextensions='websockets-next'
@WebSocket(path = "/chatsocket")
public class ChatSocket {
    @Inject
    Assistant assistant;

    @OnTextMessage
    public String onMessage(String userMessage){
        return assistant.chat(userMessage);
    }
}