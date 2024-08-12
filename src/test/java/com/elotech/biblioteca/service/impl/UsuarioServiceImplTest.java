package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.dao.UsuarioDao;
import com.elotech.biblioteca.entity.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension .class)
class UsuarioServiceImplTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioServiceImpl;

    @Mock
    private UsuarioDao usuarioDao;

    @Test
    @DisplayName("Deve retornar uma lista de usuario com um usuario")
    public void deveRetornarUmaListaDeUsuarioComUmUsuario(){
        Usuario usuario = new Usuario(1,"marcelo","marceloanzolin@teste.com.br", LocalDate.now(),"548855259961");
        Mockito.when(usuarioDao.findAll()).thenReturn(Collections.singletonList(usuario));
        List<Usuario> usuarios = usuarioDao.findAll();
        Assertions.assertEquals(1,usuarios.size());
    }
}