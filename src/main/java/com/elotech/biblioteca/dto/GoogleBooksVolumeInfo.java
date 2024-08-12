package com.elotech.biblioteca.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@JsonIgnoreProperties
public class GoogleBooksVolumeInfo {

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("authors")
    private List<String> autores;

    @JsonProperty("publisher")
    private String publicadora;

    @JsonProperty("publishedDate")
    private String dataPublicacao;

    @JsonProperty("industryIdentifiers")
    private List<GoogleBooksIdentificadores> identificadores;


}
