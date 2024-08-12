package com.elotech.biblioteca.entity.enums;

import com.elotech.biblioteca.exception.CustomException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusEmprestimo {

    FINALIZADO("Finalizado"),
    ATIVO("Ativo");

    private final String description;

    private StatusEmprestimo(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name();
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    @JsonCreator
    public static StatusEmprestimo fromName(String name) {
        for (StatusEmprestimo status : StatusEmprestimo.values()) {
            if (status.getName().equalsIgnoreCase(name)) {
                return status;
            }
        }
        throw new CustomException("Status " + name
                + " não encontrado. Status disponíveis: " + StatusEmprestimo.getListName());
    }

    public static List<StatusEmprestimo> toList() {
        return Stream.of(StatusEmprestimo.values()).collect(Collectors.toList());
    }

    public static List<String> getListName() {
        return StatusEmprestimo.toList()
                .stream()
                .map(statusEmprestimo -> statusEmprestimo.getName())
                .collect(Collectors.toList());
    }
}
