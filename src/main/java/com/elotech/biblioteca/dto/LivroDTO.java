package com.elotech.biblioteca.dto;

import com.elotech.biblioteca.entity.enums.Categoria;
import com.elotech.biblioteca.validators.isbn.validation.ValidIsbn;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LivroDTO {
    private Integer id;
    private String titulo;
    private String autor;
    private String isbn;
    private String dataPublicacao;
    private Categoria categoria;
}
