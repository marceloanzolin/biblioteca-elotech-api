package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.converter.EmprestimoConverter;
import com.elotech.biblioteca.dao.EmprestimoDao;
import com.elotech.biblioteca.dto.EmprestimoDTO;
import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.entity.enums.Categoria;
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
    private EmprestimoConverter emprestimoConverter;

    @Mock
    private EmprestimoDao emprestimoDao;

    @Test
    void testFindByIdSuccess() {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(1);

        EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
        emprestimoDTO.setId(1);

        Mockito.when(emprestimoDao.findById(Mockito.anyInt())).thenReturn(Optional.of(emprestimo));
        Mockito.when(emprestimoConverter.toDto(emprestimo)).thenReturn(emprestimoDTO);

        EmprestimoDTO result = emprestimoService.findById(1);

        Assertions.assertNotNull(result, "O resultado não deve ser nulo");
        Assertions.assertEquals(1, result.getId(), "O ID do DTO deveria ser 1");
    }
}