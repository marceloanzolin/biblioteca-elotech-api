package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.converter.UsuarioConverter;
import com.elotech.biblioteca.dao.UsuarioDao;
import com.elotech.biblioteca.dto.UsuarioDTO;
import com.elotech.biblioteca.entity.Usuario;
import com.elotech.biblioteca.exception.CustomException;
import com.elotech.biblioteca.service.UsuarioService;
import com.elotech.biblioteca.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Override
    public UsuarioDTO findById(Integer id) {
        Usuario usuario =  usuarioDao.findById(id).orElseThrow(() ->
                new CustomException(HttpStatus.NOT_FOUND,
                        "Usuário não encontrado"));
        return usuarioConverter.toDto(usuario);
    }

    @Override
    public UsuarioDTO save(Usuario usuario) {
        try {
            usuario.setTelefone(StringUtil.somenteNumeros(usuario.getTelefone()));
            Usuario usuarioSalvo =  usuarioDao.save(usuario);
            return usuarioConverter.toDto(usuarioSalvo);
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarioList = usuarioDao.findAll();
        return usuarioList.stream()
                .map((usuario) -> usuarioConverter.toDto(usuario))
                .collect(Collectors.toList());
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
