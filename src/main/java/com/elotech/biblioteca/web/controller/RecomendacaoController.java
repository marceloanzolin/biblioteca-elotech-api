package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.service.EmprestimoService;
import com.elotech.biblioteca.service.RecomendacaoService;
import com.elotech.biblioteca.web.dto.EmprestimoPatchDTO;
import com.elotech.biblioteca.web.dto.RecomendacaoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recomendacoes")
public class RecomendacaoController {

    @Autowired
    RecomendacaoService recomendacaoService;

    @Autowired
    private PagedResourcesAssembler<RecomendacaoDTO> pagedResourcesAssembler;

    @GetMapping(path = "/{idUsuario}",produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedModel<EntityModel<RecomendacaoDTO>> recomendarLivros(@PathVariable Integer idUsuario, Pageable pageable){
        Page<RecomendacaoDTO> page = recomendacaoService.obterRecomendados(idUsuario,pageable);
        return pagedResourcesAssembler.toModel(page);
    }
}
