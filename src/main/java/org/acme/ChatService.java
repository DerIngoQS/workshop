package org.acme;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ChatService {
    protected void startup(@Observes StartupEvent event) { 
        System.out.println("Startuuuuuuuuuup event");
    }

    public String chat(String message) {
        return message + " you said.";
    }
}