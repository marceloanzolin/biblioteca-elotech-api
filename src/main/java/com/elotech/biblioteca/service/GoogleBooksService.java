package com.elotech.biblioteca.service;

import com.elotech.biblioteca.dto.LivroDTO;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.dto.GoogleBooksRequest;
import com.elotech.biblioteca.dto.GoogleBooksResponse;

public interface GoogleBooksService {
     GoogleBooksResponse getBookTitle(String title);
     LivroDTO addBook(GoogleBooksRequest googleBooksRequest);
}
