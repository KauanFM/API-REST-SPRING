package com.api.smd.apismd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.smd.apismd.model.Message;
import com.api.smd.apismd.model.MessageRecord;
import com.api.smd.apismd.repository.RepositorioMensagem;

@Service
public class ServiceMensagem {

    @Autowired
    private RepositorioMensagem repositorioMensagem;

    public Message criarMensagem(MessageRecord messageRecord) {
        Message novaMensagem = new Message(messageRecord);
        return this.repositorioMensagem.save(novaMensagem);
    }

    public List<Message> listarMensagem() {
        return this.repositorioMensagem.findAll();
    }

    public void editarMensagem(Long id, MessageRecord messageRecord) {
        Optional<Message> mensagemAhEditar = this.repositorioMensagem.findById(id);
        Message mensagem = mensagemAhEditar.get();
        if (mensagem.getIdDestinatario() != messageRecord.idDestinatario()) {
            mensagem.setIdDestinatario(messageRecord.idDestinatario());
        }
        if (mensagem.getIdRemetente() != messageRecord.idRemetente()) {
            mensagem.setIdRemetente(messageRecord.idRemetente());
        }
        this.repositorioMensagem.save(mensagem);
    }

    public Message deletarMensagem(Long id) {
        Optional<Message> mensagemAhDeletar = this.repositorioMensagem.findById(id);
        this.repositorioMensagem.deleteById(id);
        return mensagemAhDeletar.get();
    }

}
