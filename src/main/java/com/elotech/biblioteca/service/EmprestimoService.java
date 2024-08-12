package com.elotech.biblioteca.service;

import com.elotech.biblioteca.dto.EmprestimoDTO;
import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.dto.EmprestimoPatch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmprestimoService {
    EmprestimoDTO findById(Integer id);
    EmprestimoDTO save(Emprestimo emprestimo);
    Page<EmprestimoDTO> findAll(Pageable pageable);
    void update(Integer id, EmprestimoPatch emprestimoPatch);
    List<Emprestimo> findByIdUsuario(Integer idUsuario);
}
