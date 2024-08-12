package com.elotech.biblioteca.service;

import com.elotech.biblioteca.dto.UsuarioDTO;
import com.elotech.biblioteca.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO findById(Integer id);
    UsuarioDTO save(Usuario usuario);
    List<UsuarioDTO> findAll();
    void deleteById(Integer id);
}
