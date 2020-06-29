package com.swagger.codegen.agendamento.controller;

import com.message.model.Custome;
import com.swagger.codegen.agendamento.api.AgendamentoApi;
import com.swagger.codegen.agendamento.model.Agendamento;
import com.swagger.codegen.agendamento.model.Debito;
import com.swagger.codegen.agendamento.model.Response;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AgendamentoController implements AgendamentoApi {

    @Autowired
    private KafkaTemplate<String, Custome> kafkaTemplate;

    @Override
    public ResponseEntity<Response> createAgendamento(@Valid Agendamento body) {
        Response response = new Response();
        response.setIdAgendamento("01010");
        /*String topic = "customer-avro";
        Custome custome = Custome.newBuilder()
                .setName("Test1")
                .setTitle("test2")
                .setDisplayName("testdisplya")
                .build();
        ProducerRecord<String, Custome> producerRecord = new ProducerRecord<String, Custome>(topic, custome);

        kafkaTemplate.send(producerRecord);*/

        return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteByIdAgendamento(@NotNull @Valid String idAgendamento) {
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<Agendamento>> findAllAgendamento() {
        List<Agendamento> listAgendamento = new ArrayList<>();
        listAgendamento.add(getAgendamento());
        return new ResponseEntity<List<Agendamento>>(listAgendamento,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Agendamento>> findByDac(@NotNull @Valid String agencia, @NotNull @Valid String conta, @NotNull @Valid String digito) {
        List<Agendamento> listAgendamento = new ArrayList<>();
        listAgendamento.add(getAgendamento());
        return new ResponseEntity<List<Agendamento>>(listAgendamento,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateAgendamento(@Valid Agendamento body) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public Agendamento getAgendamento(){
        Agendamento agendamento = new Agendamento();
        agendamento.setId("0202");
        agendamento.setAntecipaPosterga(Boolean.TRUE);
        agendamento.setIdSistemaProduto("0101");
        agendamento.setDataEfetivacao("01/10/2019");
        agendamento.setRetentativa(Boolean.FALSE);
        agendamento.setIdCanal("ATM");
        Debito debito = new Debito();
        debito.setAgencia("0001");
        debito.setConta("123456");
        debito.setDac("7");
        debito.setValor(BigDecimal.valueOf(100.56));
        agendamento.setDebito(debito);
        return agendamento;
    }
}
