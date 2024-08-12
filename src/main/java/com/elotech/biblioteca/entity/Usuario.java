package com.elotech.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name ="usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 80)
    @Column(name = "nome")
    @NotEmpty(message = "Informe o nome do usuário")
    private String nome;

    @Size(max = 255)
    @Column(name = "email")
    @NotEmpty(message = "Informe o email do usuário")
    @Email(message = "O email deve ser válido")
    private String email;

    @Column(name = "data_cadastro",updatable = false)
    private LocalDate dataCadastro = LocalDate.now();

    @Size(max = 20)
    @Column(name = "telefone")
    @NotEmpty(message = "Informe o telefone do Usuário")
    private String telefone;
}
