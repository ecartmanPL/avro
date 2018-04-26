package net.siekiera.avro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Value("${kafka.topic.avro}")
    private String avroTopic;

    @Autowired
    KafkaTemplate<String, Message> kafkaTemplate;

    public void send(Message message) {
        LOGGER.info("Sending message=" + message.toString());
        kafkaTemplate.send(avroTopic, message);
    }
}
