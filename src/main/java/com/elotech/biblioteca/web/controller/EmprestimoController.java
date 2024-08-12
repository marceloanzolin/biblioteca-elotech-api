package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.dto.EmprestimoDTO;
import com.elotech.biblioteca.dto.LivroDTO;
import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.service.EmprestimoService;
import com.elotech.biblioteca.dto.EmprestimoPatch;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/api/emprestimos")
@Tag(name = "Emprestimo Controller", description = "Gerencia as operações relacionadas ao empréstimos dos livros aos usuários")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private PagedResourcesAssembler<EmprestimoDTO> pagedResourcesAssembler;

    @Operation(description = "Obter os dados de um empréstimo pelo seu código de identificação")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo encontrado"),
            @ApiResponse(responseCode = "400", description = "Erro ao buscar as informações do empéstimo"),
            @ApiResponse(responseCode = "404", description = "Emprestimo não encontrado")
    })
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmprestimoDTO findById(@PathVariable
                               @Parameter(description = "ID do empréstimo") Integer id ){
        return emprestimoService.findById(id) ;
    }

    @Operation(description = "Cria um novo emprestimo")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Empréstimo criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao salvar as informações do empréstimo")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public EmprestimoDTO save(@RequestBody @Valid Emprestimo emprestimo ){
        return emprestimoService.save(emprestimo);
    }

    @Operation(description = "Recupera todos os empréstimos cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao realizar a consulta"),
            @ApiResponse(responseCode = "404", description = "Nenhum registro encontrado")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedModel<EntityModel<EmprestimoDTO>> findAll(Pageable pageable) {
        Page<EmprestimoDTO> page =  emprestimoService.findAll(pageable);
        return pagedResourcesAssembler.toModel(page);
    }

    @Operation(description = "Atualiza parcialmente as informações de um empréstimo.Atualiza a data de devolução e o status")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operção realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao realizar a atualização"),
            @ApiResponse(responseCode = "404", description = "Emprestimo não encontrado")
    })
    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmprestimo(@PathVariable
                                 @Parameter(description = "ID do empréstimo") Integer id,
                                 @RequestBody EmprestimoPatch emprestimoPatch){
            emprestimoService.update(id, emprestimoPatch);
    }
}
