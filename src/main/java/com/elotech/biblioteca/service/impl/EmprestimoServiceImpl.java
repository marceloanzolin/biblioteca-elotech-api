package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.dao.EmprestimoDao;
import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.exception.CustomException;
import com.elotech.biblioteca.service.EmprestimoService;
import com.elotech.biblioteca.dto.EmprestimoPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    @Autowired
    private EmprestimoDao emprestimoDao;

    @Override
    public Emprestimo findById(Integer id) {
        return emprestimoDao.findById(id).orElseThrow(() ->
                new CustomException(HttpStatus.NOT_FOUND,
                        "Empréstimo não encontrado"));
    }

    @Override
    public Emprestimo save(Emprestimo emprestimo) {
        try {
            return  emprestimoDao.save(emprestimo);
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<Emprestimo> findAll() {
        return emprestimoDao.findAll();
    }

    @Override
    public void update(Integer id, EmprestimoPatch emprestimoPatch) {
        Emprestimo emprestimo = this.findById(id);
        emprestimo.setStatus(emprestimoPatch.getStatus());
        emprestimo.setDataDevolucao(emprestimoPatch.getDataDevolucao());
        save(emprestimo);
    }

    public List<Emprestimo> findByIdUsuario(Integer idUsuario){
        return emprestimoDao.findByIdUsuario(idUsuario);
    }
}
