package com.elotech.biblioteca.dto;

import com.elotech.biblioteca.entity.enums.StatusEmprestimo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmprestimoPatch {
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;
    private LocalDate dataDevolucao;
}
