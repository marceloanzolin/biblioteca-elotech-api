package com.elotech.biblioteca.service;

import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.web.dto.RecomendacaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RecomendacaoService {
    public Page<RecomendacaoDTO> obterRecomendados(Integer idUsuario, Pageable pageable);
}
