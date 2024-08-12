package com.elotech.biblioteca.service;

import com.elotech.biblioteca.dto.LivroDTO;
import com.elotech.biblioteca.entity.enums.Categoria;
import com.elotech.biblioteca.entity.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LivroService {
     LivroDTO findById(Integer id);
     LivroDTO save(Livro livro);
     void deleteById(Integer id);
     Optional<Livro> findByIsbn(String isbn);
     Page<LivroDTO> findAll(String titulo, String autor, String isbn, Pageable pageable);
     List<Livro> getByCategoria(List<Categoria> listCategoria);

}
