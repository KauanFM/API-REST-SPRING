package com.api.smd.apismd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.smd.apismd.model.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
