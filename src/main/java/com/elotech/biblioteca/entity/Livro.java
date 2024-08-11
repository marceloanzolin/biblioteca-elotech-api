package com.elotech.biblioteca.entity;

import com.elotech.biblioteca.entity.Enum.Categoria;
import com.elotech.biblioteca.entity.validation.ValidIsbn;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name ="livros")
@NoArgsConstructor
@Getter
@Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 80)
    @Column(name = "titulo")
    @NotEmpty(message = "Informe o titulo do livro")
    private String titulo;

    @Size(max = 80)
    @Column(name = "autor")
    @NotEmpty(message = "Informe o autor do livro")
    private String autor;

    @ValidIsbn
    @Column(name = "isbn")
    @NotEmpty(message = "Informe o ISBN do livro")
    private String isbn;

    @Column(name = "data_publicacao")
    @NotNull(message = "Informe a data de publicação do livro")
    private LocalDate dataPublicacao;

    @Column(name = "categoria")
    @NotNull(message = "Informe a categoria do livro")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
