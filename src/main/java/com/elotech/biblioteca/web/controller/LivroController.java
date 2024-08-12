package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.service.LivroService;
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

@RestController
@RequestMapping("/api/livros")
@Tag(name = "Livro Controller", description = "Gerencia as operações relacionadas a livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private PagedResourcesAssembler<Livro> pagedResourcesAssembler;

    @Operation(description = "Obter os dados de um livro pelo seu código de identificação")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Livro encontrado"),
            @ApiResponse(responseCode = "400", description = "Erro ao buscar as informações do livro"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    })
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Livro findById(
            @PathVariable
            @Parameter(description = "ID do livro") Integer id){
            return livroService.findById(id) ;
    }

    @Operation(description = "Cria um novo livro")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Livro criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao salvar as informações do livro")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Livro save( @RequestBody
                       @Valid Livro livro){
            return livroService.save(livro);
    }

    @Operation(description = "Atualiza as informações de um livro")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Livro atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar as informações do livro"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado para o ID informado")
    })
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable @Parameter(description = "ID do livro") Integer id,
                        @Valid
                        @RequestBody Livro livro ){
        Livro livroEncontrado = livroService.findById(id);
        livro.setId(livroEncontrado.getId());
        livroService.save(livro);
    }

    @Operation(description = "Exclui um livro")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Livro excluido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao excluir o livro"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado para o ID informado")
    })
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable
                       @Parameter(description = "ID do livro") Integer id){
        livroService.findById(id);
        livroService.deleteById(id);
    }

    @Operation(description = "Recupera os livros cadastrados paginados de acordo com os filtros informados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao realizar a consulta")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public PagedModel<EntityModel<Livro>> findAll(@RequestParam(required = false)
                                                  @Parameter(description = "Titulo do livro") String titulo,
                                                  @RequestParam(required = false)
                                                  @Parameter(description = "Autor do livro") String autor,
                                                  @RequestParam(required = false)
                                                  @Parameter(description = "Isbn  do livro") String isbn,
                                                  @Parameter(description = "Informações referentes a paginação e ordenação da lista") Pageable pageable){
        Page<Livro> page =  livroService.findAll(titulo, autor, isbn, pageable);
        return pagedResourcesAssembler.toModel(page);
    }
}
