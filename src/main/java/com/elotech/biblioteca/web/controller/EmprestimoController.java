package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.service.EmprestimoService;
import com.elotech.biblioteca.web.dto.EmprestimoPatchDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

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
    public void updateEmprestimo(@PathVariable Integer id,
                       @RequestBody EmprestimoPatchDTO emprestimoPatchDTO){
            emprestimoService.updateEmprestimo(id, emprestimoPatchDTO);
    }

}
