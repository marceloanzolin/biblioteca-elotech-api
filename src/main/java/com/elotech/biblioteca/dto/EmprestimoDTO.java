package com.elotech.biblioteca.dto;

import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.entity.Usuario;
import com.elotech.biblioteca.entity.enums.StatusEmprestimo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmprestimoDTO {
    private Integer id;
    private UsuarioDTO usuario;
    private LivroDTO livro;
    private String dataEmprestimo;
    private String dataDevolucao;
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;
}
