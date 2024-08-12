package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.dao.LivroDao;
import com.elotech.biblioteca.entity.enums.Categoria;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.exception.CustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension .class)
class LivroServiceImplTest {

    @InjectMocks
    private LivroServiceImpl livroServiceImpl;

    @Mock
    private LivroDao livroDao;

    @Test
    @DisplayName("Deve lançar uma exceção quando tentar inserir um livro com isbn já existente")
    public void deveLancarExececaoQuandoTentarInserirUmaIsbnJaExistente(){

        Livro livro = new Livro(null, "Titulo", "Paulo", "9955445599999", LocalDate.now(), Categoria.ARTES);
        Livro livroExistente = new Livro(1, "Titulo A", "Paulo A", "9955445599999", LocalDate.now(), Categoria.ARTES);
        Mockito.when(livroDao.findByIsbn(livro.getIsbn())).thenReturn(Optional.of(livroExistente));

        Assertions.assertThrows(CustomException.class, () -> {
            livroServiceImpl.save(livro);
        });
    }



}