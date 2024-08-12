package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.converter.EmprestimoConverter;
import com.elotech.biblioteca.dao.EmprestimoDao;
import com.elotech.biblioteca.dao.specs.LivroSpecs;
import com.elotech.biblioteca.dto.EmprestimoDTO;
import com.elotech.biblioteca.dto.LivroDTO;
import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.exception.CustomException;
import com.elotech.biblioteca.service.EmprestimoService;
import com.elotech.biblioteca.dto.EmprestimoPatch;
import com.elotech.biblioteca.util.DateUtil;
import com.elotech.biblioteca.util.StringUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    @Autowired
    private EmprestimoDao emprestimoDao;

    @Autowired
    private EmprestimoConverter emprestimoConverter;

    @Override
    public EmprestimoDTO findById(Integer id) {
        Emprestimo emprestimo =  emprestimoDao.findById(id).orElseThrow(() ->
                new CustomException(HttpStatus.NOT_FOUND,
                        "Empréstimo não encontrado"));
        return emprestimoConverter.toDto(emprestimo);
    }

    @Override
    public EmprestimoDTO save(Emprestimo emprestimo) {
        try {
            Emprestimo emprestimoSalvo = emprestimoDao.save(emprestimo);
            return emprestimoConverter.toDto(emprestimoSalvo);
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public Page<EmprestimoDTO> findAll(Pageable pageable) {
        Page<Emprestimo> pageEmprestimo =  emprestimoDao.findAll(pageable);
        return pageEmprestimo.map((emp) -> emprestimoConverter.toDto(emp));
    }

    @Transactional
    @Override
    public void update(Integer id, EmprestimoPatch emprestimoPatch) {
        EmprestimoDTO emprestimoDTO = this.findById(id);
        Emprestimo emprestimo = emprestimoConverter.toEntity(emprestimoDTO);
        emprestimo.setStatus(emprestimoPatch.getStatus());
        emprestimo.setDataDevolucao(emprestimoPatch.getDataDevolucao());
        save(emprestimo);
    }

    public List<Emprestimo> findByIdUsuario(Integer idUsuario){
        return emprestimoDao.findByIdUsuario(idUsuario);
    }
}
