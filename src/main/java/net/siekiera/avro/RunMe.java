package net.siekiera.avro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunMe implements CommandLineRunner {
    @Autowired
    Sender sender;

    @Override
    public void run(String... args) throws Exception {
        Message message = Message.newBuilder().setHeader("header").setContent("content").setId(1).build();
        sender.send(message);
    }
}
