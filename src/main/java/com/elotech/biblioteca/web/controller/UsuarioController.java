package com.elotech.biblioteca.web.controller;

import com.elotech.biblioteca.converter.UsuarioConverter;
import com.elotech.biblioteca.dto.UsuarioDTO;
import com.elotech.biblioteca.entity.Usuario;
import com.elotech.biblioteca.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuário Controller", description = "Gerencia as operações relacionadas a usuários")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Operation(description = "Obter os dados de um usuário pelo seu código de identificação")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "400", description = "Erro ao buscar as informações do usuário"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO usuarioById(@PathVariable
                               @Parameter(description = "ID do usuário") Integer id ){
        return usuarioService.findById(id) ;
    }

    @Operation(description = "Cria um novo usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao salvar as informações do usuário")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO save( @RequestBody @Valid Usuario usuario ){
        return usuarioService.save(usuario);
    }

    @Operation(description = "Recupera todos os usuários cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao realizar a consulta")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDTO> findAll() {
         return usuarioService.findAll();
    }

    @Operation(description = "Atualiza as informações de um usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar as informações do usuário"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado para o ID informado")
    })
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable
                        @Parameter(description = "ID do usuário") Integer id,
                        @Valid @RequestBody Usuario usuario ){

            UsuarioDTO usuarioEncontrado = usuarioService.findById(id);
            usuario.setId(usuarioEncontrado.getId());
            usuarioService.save(usuario);
    }

    @Operation(description = "Exclui um usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuário excluido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao excluir o usuário"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado para o ID informado")
    })
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable
                       @Parameter(description = "ID do usuário") Integer id){
            usuarioService.findById(id);
            usuarioService.deleteById(id);
    }
}
