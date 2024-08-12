package com.elotech.biblioteca.entity.enums;

import com.elotech.biblioteca.exception.CustomException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Categoria {

    GENERALIDADES("Generalidades"),
    FILOSOFIA("Filosofia"),
    RELIGIAO("Religião"),
    CIENCIAS_SOCIAIS("Ciências Sociais"),
    LINGUAS("Línguas"),
    CIENCIAS_PURAS("Ciências Puras"),
    CIENCIAS_APLICADAS("Ciências Aplicadas"),
    ARTES("Artes"),
    LITERATURA("Literatura"),
    HISTORIA_GEOGRAFIA("História e Geografia"),
    OUTRAS("Outras");

    private final String description;

    private Categoria(String description) {
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
    public static Categoria fromName(String name) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getName().equalsIgnoreCase(name)) {
                return categoria;
            }
        }
        throw new CustomException("Categoria " + name
                + " não encontrada. Escolha uma das categorias disponíveis: " + Categoria.getListName());
    }

    public static List<Categoria> toList() {
        return Stream.of(Categoria.values()).collect(Collectors.toList());
    }

    public static List<String> getListName() {
        return Categoria.toList()
                .stream()
                .map(categoria -> categoria.getName())
                .collect(Collectors.toList());
    }
}
