package com.elotech.biblioteca.service;

import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.dto.EmprestimoPatch;

import java.util.List;

public interface EmprestimoService {
    Emprestimo findById(Integer id);
    Emprestimo save(Emprestimo emprestimo);
    List<Emprestimo> findAll();
    void update(Integer id, EmprestimoPatch emprestimoPatch);
    List<Emprestimo> findByIdUsuario(Integer idUsuario);
}
