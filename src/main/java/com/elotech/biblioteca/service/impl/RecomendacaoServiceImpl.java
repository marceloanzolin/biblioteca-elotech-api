package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.entity.Enum.Categoria;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.service.EmprestimoService;
import com.elotech.biblioteca.service.LivroService;
import com.elotech.biblioteca.service.RecomendacaoService;
import com.elotech.biblioteca.web.dto.RecomendacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacaoServiceImpl implements RecomendacaoService {

    @Autowired
    EmprestimoService emprestimoService;

    @Autowired
    LivroService livroService;

    @Override
    public Page<RecomendacaoDTO> obterRecomendados(Integer idUsuario, Pageable pageable) {

        List<Emprestimo> listaEmprestados = emprestimoService.findByIdUsuario(idUsuario);

        List<Categoria> categoriasEmprestadas = listaEmprestados.stream()
                .map(e-> e.getLivro().getCategoria())
                .distinct()
                .toList();

        List<Livro> livrosCategoria = livroService.getByCategoria(categoriasEmprestadas);

        List<Livro> livrosDisponiveis =  livrosCategoria.stream()
                .filter(lc ->
                            listaEmprestados.stream()
                                    .noneMatch(le -> le.getLivro().getId().equals(lc.getId()) &&
                                            le.getLivro().getCategoria().equals(lc.getCategoria())))
                .toList();

        List<RecomendacaoDTO> livrosRecomendados = criarRecomendacaoDTOS(livrosDisponiveis);

        return new PageImpl <>(livrosRecomendados,pageable,livrosRecomendados.size());
    }

    private static List<RecomendacaoDTO> criarRecomendacaoDTOS(List<Livro> livrosDisponiveis) {
        return livrosDisponiveis.stream()
                .map(livro -> RecomendacaoDTO.builder()
                        .titulo(livro.getTitulo())
                        .autor(livro.getAutor())
                        .isbn(livro.getIsbn())
                        .categoria(livro.getCategoria())
                        .build()).toList();
    }
}
