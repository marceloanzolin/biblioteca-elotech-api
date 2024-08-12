package com.elotech.biblioteca.service;

import com.elotech.biblioteca.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario findById(Integer id);
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    void deleteById(Integer id);
}
