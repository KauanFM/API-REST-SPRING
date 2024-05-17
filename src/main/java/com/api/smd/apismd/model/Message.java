package com.api.smd.apismd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "mensagem")
@Table(name = "mensagens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "idDestinatario", referencedColumnName = "id")
    private Long idDestinatario;
    @JoinColumn(name = "idRemetente", referencedColumnName = "id")
    private Long idRemetente;
    private String mensagem;

    public Message(MessageRecord messageRecord) {
        this.id = messageRecord.id();
        this.idDestinatario = messageRecord.idDestinatario();
        this.idRemetente = messageRecord.idRemetente();
        this.mensagem = messageRecord.mensagem();
    }

}
