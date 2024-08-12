package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.service.RecomendacaoService;
import com.elotech.biblioteca.dto.Recomendacao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recomendacoes")
@Tag(name = "Recomendação Controllee", description = "Gerencia as informações relacionadas as recomendações de locação para os usuários")
public class RecomendacaoController {

    @Autowired
    private RecomendacaoService recomendacaoService;

    @Autowired
    private PagedResourcesAssembler<Recomendacao> pagedResourcesAssembler;

    @Operation(description = "Retorna uma lista página com os livros recomendados para o usuário de acordo com as categorias dos livros já locados por ele")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Existem recomendações de livros para o usuário"),
            @ApiResponse(responseCode = "400", description = "Erro ao buscar as recomendações de livros"),
            @ApiResponse(responseCode = "404", description = "Não foram encontradas recomendações de livros para o usuário")
    })
    @GetMapping(path = "/{idUsuario}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public PagedModel<EntityModel<Recomendacao>> recomendarLivros(@PathVariable
                                                                  @Parameter(description = "ID do usuário") Integer idUsuario,
                                                                  @Parameter(description = "Informações referentes a paginação e ordenação da lista ") Pageable pageable){
        Page<Recomendacao> page = recomendacaoService.obterRecomendados(idUsuario,pageable);
        return pagedResourcesAssembler.toModel(page);
    }
}
