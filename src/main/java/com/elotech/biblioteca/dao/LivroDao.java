package com.elotech.biblioteca.dao;

import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.entity.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivroDao extends JpaRepository<Livro,Integer>, JpaSpecificationExecutor<Livro> {
    Optional<Livro> findByIsbn(String isbn);
    @Query("SELECT l from Livro l where l.categoria in :listCategoria")
    List<Livro> getByCategoria(List<Categoria> listCategoria);
}
