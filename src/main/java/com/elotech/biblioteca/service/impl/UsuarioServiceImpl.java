package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.dao.UsuarioDao;
import com.elotech.biblioteca.entity.Usuario;
import com.elotech.biblioteca.exception.CustomException;
import com.elotech.biblioteca.service.UsuarioService;
import com.elotech.biblioteca.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElseThrow(() ->
                new CustomException(HttpStatus.NOT_FOUND,
                        "Usuário não encontrado"));
    }

    @Override
    public Usuario save(Usuario usuario) {
        try {
            usuario.setTelefone(StringUtil.somenteNumeros(usuario.getTelefone()));
            return usuarioDao.save(usuario);
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        try {
            usuarioDao.deleteById(id);
        } catch (Exception e) {
           throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
