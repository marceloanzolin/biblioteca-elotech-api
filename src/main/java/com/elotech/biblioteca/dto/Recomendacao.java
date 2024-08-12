package com.elotech.biblioteca.dto;

import com.elotech.biblioteca.entity.enums.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Recomendacao {
    private String titulo;
    private String autor;
    private String isbn;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
