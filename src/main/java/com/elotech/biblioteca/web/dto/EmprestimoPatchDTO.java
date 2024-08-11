package com.elotech.biblioteca.web.dto;

import com.elotech.biblioteca.entity.Enum.StatusEmprestimo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmprestimoPatchDTO {

    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;
    private LocalDate dataDevolucao;
}
