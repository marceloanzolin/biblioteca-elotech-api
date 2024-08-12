package com.elotech.biblioteca.converter;

import com.elotech.biblioteca.dto.LivroDTO;
import com.elotech.biblioteca.dto.UsuarioDTO;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.entity.Usuario;
import com.elotech.biblioteca.util.DateUtil;
import com.elotech.biblioteca.util.StringUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LivroConverter {

    @Autowired
    private ModelMapper modelMapper;

    public LivroDTO toDto(Livro livro) {
        LivroDTO livroDTO =  modelMapper.map(livro, LivroDTO.class);

        if (livroDTO.getDataPublicacao() != null) {
            livroDTO.setDataPublicacao(DateUtil.localDateToString(livro.getDataPublicacao()));
        }

        if(livroDTO.getIsbn() != null){
            livroDTO.setIsbn(StringUtil.formataIsbn(livro.getIsbn()));
        }

        return livroDTO;
    }

    public Livro toEntity(LivroDTO livroDTO) {
        return modelMapper.map(livroDTO, Livro.class);
    }
}
