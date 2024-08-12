package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.dao.EmprestimoDao;
import com.elotech.biblioteca.entity.Emprestimo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class EmprestimoServiceImplTest {

    @InjectMocks
    private EmprestimoServiceImpl emprestimoService;

    @Mock
    private EmprestimoDao emprestimoDao;

    @Test
    void testFindByIdSuccess() {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(1);
        Mockito.when(emprestimoDao.findById(Mockito.anyInt())).thenReturn(Optional.of(emprestimo));
        Emprestimo result = emprestimoService.findById(1);
        Assertions.assertEquals(1, result.getId());
    }
}