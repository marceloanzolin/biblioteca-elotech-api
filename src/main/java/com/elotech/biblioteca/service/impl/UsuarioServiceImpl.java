package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.dao.UsuarioDao;
import com.elotech.biblioteca.entity.Usuario;
import com.elotech.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDao usuarioDao;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
            return usuarioDao.findById(id);

    }

    @Override
    public void deleteById(Integer id) {
        usuarioDao.deleteById(id);
    }

    @Override
    public List<Usuario> findAll() {
       return usuarioDao.findAll();
    }
}
