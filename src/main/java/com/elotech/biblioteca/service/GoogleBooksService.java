package com.elotech.biblioteca.service;

import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.service.google.dto.GoogleBooksRequest;
import com.elotech.biblioteca.service.google.dto.GoogleBooksResponse;

public interface GoogleBooksService {
     GoogleBooksResponse getBookTitle(String title);
     Livro addBook(GoogleBooksRequest googleBooksRequest);
}
