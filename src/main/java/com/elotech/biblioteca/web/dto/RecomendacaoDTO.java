package com.elotech.biblioteca.web.dto;

import com.elotech.biblioteca.entity.Enum.Categoria;
import com.elotech.biblioteca.entity.Enum.StatusEmprestimo;
import com.elotech.biblioteca.entity.Livro;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Builder
public class RecomendacaoDTO {

    private String titulo;
    private String autor;
    private String isbn;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
