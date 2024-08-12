package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.service.EmprestimoService;
import com.elotech.biblioteca.dto.EmprestimoPatch;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
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
    private PagedResourcesAssembler<Emprestimo> pagedResourcesAssembler;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Emprestimo findById(@PathVariable Integer id ){
        return emprestimoService.findById(id) ;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Emprestimo save( @RequestBody @Valid Emprestimo emprestimo ){
        return emprestimoService.save(emprestimo);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Emprestimo> findAll() {
        return emprestimoService.findAll();
    }

    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmprestimo(@PathVariable Integer id, @RequestBody EmprestimoPatch emprestimoPatch){
            emprestimoService.update(id, emprestimoPatch);
    }
}
