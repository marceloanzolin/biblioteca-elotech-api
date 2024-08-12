package com.elotech.biblioteca.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Integer id;
    private String nome;
    private String email;
    private String dataCadastro;
    private String telefone;
}
