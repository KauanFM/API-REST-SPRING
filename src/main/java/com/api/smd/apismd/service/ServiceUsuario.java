package com.api.smd.apismd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.smd.apismd.model.Usuario;
import com.api.smd.apismd.model.UsuarioRecord;
import com.api.smd.apismd.repository.RepositorioUsuario;

@Service
public class ServiceUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario criarUsuario(UsuarioRecord usuarioRecord) {
        Usuario novoUsuario = new Usuario(usuarioRecord);
        return this.repositorioUsuario.save(novoUsuario);
    }

    public List<Usuario> listarUsuarios() {
        return this.repositorioUsuario.findAll();
    }

    public void editarUsuario(Long id, UsuarioRecord usuarioRecord) {
        Optional<Usuario> usuarioAhEditar = this.repositorioUsuario.findById(id);
        Usuario usuario = usuarioAhEditar.get();
        if (usuario.getUsuario() != usuarioRecord.usuario()) {
            usuario.setUsuario(usuarioRecord.usuario());
        }
        this.repositorioUsuario.save(usuario);
    }

    public Usuario deletarUsuario(Long id) {
        Optional<Usuario> usuarioAhDeletar = this.repositorioUsuario.findById(id);
        this.repositorioUsuario.deleteById(id);
        return usuarioAhDeletar.get();
    }

}
