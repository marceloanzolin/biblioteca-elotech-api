package com.elotech.biblioteca.service;

import com.elotech.biblioteca.entity.enums.Categoria;
import com.elotech.biblioteca.entity.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LivroService {
     Livro findById(Integer id);
     Livro save(Livro livro);
     List<Livro> findAll();
     void deleteById(Integer id);
     Optional<Livro> findByIsbn(String isbn);
     Page<Livro> findAll(String titulo, String autor, String isbn, Pageable pageable);
     List<Livro> getByCategoria(List<Categoria> listCategoria);

}
