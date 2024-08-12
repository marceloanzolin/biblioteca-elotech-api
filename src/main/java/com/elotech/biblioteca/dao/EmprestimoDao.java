package com.elotech.biblioteca.dao;

import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmprestimoDao extends JpaRepository<Emprestimo,Integer>, JpaSpecificationExecutor<Emprestimo> {
    @Query("SELECT emp FROM Emprestimo emp left join fetch emp.livro where emp.usuario.id = :idUsuario")
    public List<Emprestimo> findByIdUsuario(Integer idUsuario);
}
