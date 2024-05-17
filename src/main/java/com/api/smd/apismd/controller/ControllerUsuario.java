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

import com.api.smd.apismd.model.Usuario;
import com.api.smd.apismd.model.UsuarioRecord;
import com.api.smd.apismd.service.ServiceUsuario;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioRecord usuarioRecord) {
        Usuario novoUsuario = serviceUsuario.criarUsuario(usuarioRecord);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listUsuario() {
        var usuarios = serviceUsuario.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateMessage(@PathVariable Long id, @RequestBody UsuarioRecord usuarioRecord) {
        serviceUsuario.editarUsuario(id, usuarioRecord);
        Usuario usuario = new Usuario(usuarioRecord);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteMessage(@PathVariable Long id) {
        var usuario = serviceUsuario.deletarUsuario(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
