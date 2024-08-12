package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.converter.LivroConverter;
import com.elotech.biblioteca.dto.LivroDTO;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.entity.enums.Categoria;
import com.elotech.biblioteca.exception.CustomException;
import com.elotech.biblioteca.service.GoogleBooksService;
import com.elotech.biblioteca.service.LivroService;
import com.elotech.biblioteca.dto.GoogleBooksRequest;
import com.elotech.biblioteca.dto.GoogleBooksResponse;
import com.elotech.biblioteca.dto.GoogleBooksVolumeInfo;
import com.elotech.biblioteca.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;

@Service
public class GoogleBooksServiceImpl implements GoogleBooksService {

    private static final String  URL_GOOGLE_BOOKS = "https://www.googleapis.com/books/v1/volumes";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LivroService livroService;

    @Autowired
    private LivroConverter livroConverter;

    @Override
    public GoogleBooksResponse getBookTitle(String title) {
        String url = String.format("%s?q=intitle:%s", URL_GOOGLE_BOOKS, title);
        try {
            return restTemplate.getForObject(url, GoogleBooksResponse.class);
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Erro ao buscar as informações do livro na api do Google Books", e);
        }

    }

    @Override
    public LivroDTO addBook(GoogleBooksRequest googleBooksRequest) {
        GoogleBooksResponse googleBooksResponse = this.getBookTitle(googleBooksRequest.getTitle());

            if (googleBooksResponse != null && googleBooksResponse.getItems() != null && !googleBooksResponse.getItems().isEmpty()) {
                GoogleBooksVolumeInfo googleBooksVolumeInfo = googleBooksResponse.getItems().get(0).getGoogleBooksVolumeInfo();

                Livro livroRetornado = Livro.builder().autor(googleBooksVolumeInfo.getAutores().get(0))
                        .titulo(googleBooksVolumeInfo.getTitulo())
                        .dataPublicacao(DateUtil.stringToLocalDate(googleBooksVolumeInfo.getDataPublicacao(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                        .isbn(googleBooksVolumeInfo.getIdentificadores().get(0).getIdentifier())
                        .categoria(Categoria.OUTRAS)
                        .build();

                return livroService.save(livroRetornado);
            }
        throw new CustomException(HttpStatus.NOT_FOUND, "Livro não encontrado no Google Books");
    }
}
