package com.kafka.consumer.consumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaConsumer {

    @KafkaListener(topics = "nome-topic", groupId = "group-id-topic", containerFactory = "kafkaListenerContainerFactory")
    fun consumer(any: Any){
        
    }
}