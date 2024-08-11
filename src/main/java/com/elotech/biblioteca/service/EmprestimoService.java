package com.elotech.biblioteca.service;

import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.web.dto.EmprestimoPatchDTO;

import java.util.List;

public interface EmprestimoService {
    public Emprestimo findById(Integer id);
    public Emprestimo save(Emprestimo emprestimo);
    public List<Emprestimo> findAll();
    public void updateEmprestimo(Integer id, EmprestimoPatchDTO emprestimoPatchDTO);
    public List<Emprestimo> findByIdUsuario(Integer idUsuario);
   // public Page<Livro> findAll(String titulo, String autor, String isbn, Pageable pageable);
}
