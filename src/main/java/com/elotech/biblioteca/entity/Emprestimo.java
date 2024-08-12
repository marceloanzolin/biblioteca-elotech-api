package com.elotech.biblioteca.entity;

import com.elotech.biblioteca.entity.enums.StatusEmprestimo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Informe o usuário")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @NotNull(message = "Informe o livro")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id", referencedColumnName = "id", nullable = false)
    private Livro livro;

    @NotNull(message = "Informe a data do empréstimo")
    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;

    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;

    @NotNull(message = "Informe o Status do empréstimo")
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;


}
