package com.api.smd.apismd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.smd.apismd.model.Message;
import com.api.smd.apismd.model.MessageRecord;
import com.api.smd.apismd.service.ServiceMensagem;

@RestController
@RequestMapping("/mensagem")
public class ControllerMensagem {

    @Autowired
    private ServiceMensagem serviceMensagem;

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody MessageRecord messageRecord) {
        Message novaMensagem = serviceMensagem.criarMensagem(messageRecord);
        return new ResponseEntity<>(novaMensagem, HttpStatus.CREATED);
    } 

    @GetMapping
    public ResponseEntity<List<Message>> listMessage() {
        var mensagens = serviceMensagem.listarMensagem();
        return new ResponseEntity<>(mensagens, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody MessageRecord messageRecord) {
        serviceMensagem.editarMensagem(id, messageRecord);
        Message mensagem = new Message(messageRecord);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteMessage(@PathVariable Long id) {
        var mensagem = serviceMensagem.deletarMensagem(id);
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

}
