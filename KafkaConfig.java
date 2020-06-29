package com.swagger.codegen.agendamento.config;

import com.message.model.Custome;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, Custome> producerFactory(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.ACKS_CONFIG, "1");
        config.put(ProducerConfig.RETRIES_CONFIG, "10");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        config.put("schema.registry.url", "http://localhost:8081");

        return new DefaultKafkaProducerFactory(config);
        /*KafkaProducer producer = new KafkaProducer(config);
        String topic = "customer-avro";

        Custome custome = Custome.newBuilder()
                        .setName("Test1")
                        .setTitle("test2")
                        .setDisplayName("testdisplya")
                        .build();
        ProducerRecord<String, Custome> producerRecord = new ProducerRecord<String, Custome>(topic, custome);
        producer.send(producerRecord);*/
    }

    @Bean
    public KafkaTemplate<String, Custome> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
