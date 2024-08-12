package com.elotech.biblioteca.dao;

import com.elotech.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario,Integer> {
}
