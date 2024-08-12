package com.elotech.biblioteca.converter;

import com.elotech.biblioteca.dto.UsuarioDTO;
import com.elotech.biblioteca.entity.Usuario;
import com.elotech.biblioteca.util.DateUtil;
import com.elotech.biblioteca.util.StringUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO usuarioDTO =  modelMapper.map(usuario, UsuarioDTO.class);

        if (usuarioDTO.getDataCadastro() != null) {
            usuarioDTO.setDataCadastro(DateUtil.localDateToString(usuario.getDataCadastro()));
        }

        if(usuarioDTO.getTelefone() != null){
            usuarioDTO.setTelefone(StringUtil.formataTelefone(usuario.getTelefone()));
        }

        return usuarioDTO;
    }

    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }
}
