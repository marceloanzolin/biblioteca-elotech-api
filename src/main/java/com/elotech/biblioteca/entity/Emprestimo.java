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
public class Emprestimo {

    @Id
    @Setter
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

    @Setter
    @NotNull(message = "Informe a data do empréstimo")
    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;

    @Setter
    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;

    @Setter
    @NotNull(message = "Informe o Status do empréstimo")
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;


}
