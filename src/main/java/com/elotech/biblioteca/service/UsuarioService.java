package com.elotech.biblioteca.service;

import com.elotech.biblioteca.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public Optional<Usuario> findById(Integer id);
    public Usuario save(Usuario usuario);
    public List<Usuario> findAll();
    public void deleteById(Integer id);
}
