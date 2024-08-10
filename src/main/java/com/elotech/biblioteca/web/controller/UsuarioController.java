package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.entity.Usuario;
import com.elotech.biblioteca.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios/")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario usuarioById(@PathVariable Integer id ){
        return usuarioService
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Usuário não encontrado"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save( @RequestBody @Valid Usuario usuario ){
        return usuarioService.save(usuario);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Usuario usuario ){
        usuarioService
                .findById(id)
                .map( usuarioEncontrado -> {
                    usuario.setId(usuarioEncontrado.getId());
                    usuarioService.save(usuario);
                    return usuarioEncontrado;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuário não encontrado") );
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
            usuarioService.findById(id)
                    .map(cliente -> {
                        usuarioService.deleteById(id);
                        return cliente;
                    }).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Usuário não encontrado")
                    );
    }

}
