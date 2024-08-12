package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.dto.LivroDTO;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.service.GoogleBooksService;
import com.elotech.biblioteca.dto.GoogleBooksRequest;
import com.elotech.biblioteca.dto.GoogleBooksResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/google-books")
@Tag(name = "Google Books Controller", description = "Gerencia as operações relacionadas a busca de livros na API do Google Books")
public class GoogleBooksController {

    @Autowired
    private GoogleBooksService googleBooksService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Obter os dados de um livro na API do Google Books pelo título")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Livro encontrado"),
            @ApiResponse(responseCode = "400", description = "Erro ao buscar as informações do livro"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    })
    public GoogleBooksResponse findById(@RequestParam
                                        @Parameter(description = "Titulo do livro") String title){
         return googleBooksService.getBookTitle(title);
    }

    @Operation(description = "Adiciona um livro encontrado no Google Books na biblioteca")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public LivroDTO addBook(@RequestBody GoogleBooksRequest googleBooksRequest){
        return googleBooksService.addBook(googleBooksRequest);
    }
}
