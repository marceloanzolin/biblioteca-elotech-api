package com.elotech.biblioteca.dao;

import com.elotech.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDao extends JpaRepository<Usuario,Integer> {
}
