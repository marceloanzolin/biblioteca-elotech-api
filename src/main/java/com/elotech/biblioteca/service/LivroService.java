package com.elotech.biblioteca.service;

import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LivroService {
    public Livro findById(Integer id);
    public Livro save(Livro livro);
    public List<Livro> findAll();
    public void deleteById(Integer id);
    public Optional<Livro> findByIsbn(String isbn);
    public Page<Livro> findAll(String titulo, String autor, String isbn, Pageable pageable);
}
