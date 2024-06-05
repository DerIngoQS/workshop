package org.acme;

import jakarta.ws.rs.Produces;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;


@Path("/mail")
public class MailResource {

    @Inject
    Mailer mailer;

    @Inject
    ReactiveMailer reactiveMailer;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/subject/{subject}")
    public Uni<String> mail(String subject) {
        // Reactive API:
        Uni<Void> stage = reactiveMailer.send(Mail.withText("to@acme.org", subject, "This is Reactive body.").setFrom("noreply@acme.org"));

        Uni<String> resultUni = stage
        .onItem().transform(unused -> "Email sent successfully")
        .onFailure().recoverWithItem(failure -> "Failed to send email: " + failure.getMessage());

        return resultUni;
    }
}