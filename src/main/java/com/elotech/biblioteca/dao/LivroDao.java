package com.elotech.biblioteca.dao;

import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface LivroDao extends JpaRepository<Livro,Integer>, JpaSpecificationExecutor<Livro> {
    public Optional<Livro> findByIsbn(String isbn);
}
