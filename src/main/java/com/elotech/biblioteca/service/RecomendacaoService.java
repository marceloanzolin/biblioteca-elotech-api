package com.elotech.biblioteca.service;

import com.elotech.biblioteca.dto.Recomendacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecomendacaoService {
    Page<Recomendacao> obterRecomendados(Integer idUsuario, Pageable pageable);
}
