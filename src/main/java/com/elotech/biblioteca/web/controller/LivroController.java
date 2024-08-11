package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.service.LivroService;
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
public class LivroController {

    @Autowired
    LivroService livroService;

    @Autowired
    private PagedResourcesAssembler<Livro> pagedResourcesAssembler;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Livro findById(@PathVariable Integer id ){
            return livroService.findById(id) ;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Livro save( @RequestBody @Valid Livro livro ){
            return livroService.save(livro);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedModel<EntityModel<Livro>> findAll(@RequestParam(required = false) String titulo,
                                                  @RequestParam(required = false) String autor,
                                                  @RequestParam(required = false) String isbn,
                                                  Pageable pageable) {
        Page<Livro> page =  livroService.findAll(titulo, autor, isbn, pageable);
        return pagedResourcesAssembler.toModel(page);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @Valid @RequestBody Livro livro ){
            Livro livroEncontrado = livroService.findById(id);
            livro.setId(livroEncontrado.getId());
            livroService.save(livro);
    }



    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
            livroService.findById(id);
            livroService.deleteById(id);
    }

}
