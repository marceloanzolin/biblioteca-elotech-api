package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.dao.EmprestimoDao;
import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.exception.RegraNegocioException;
import com.elotech.biblioteca.service.EmprestimoService;
import com.elotech.biblioteca.web.dto.EmprestimoPatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    @Autowired
    EmprestimoDao emprestimoDao;

    @Override
    public Emprestimo findById(Integer id) {
        return emprestimoDao.findById(id).orElseThrow(() ->
                new  RegraNegocioException(HttpStatus.NOT_FOUND,
                        "Empréstimo não encontrado"));
    }

    @Override
    public Emprestimo save(Emprestimo emprestimo) {
        try {
            return  emprestimoDao.save(emprestimo);
        } catch (Exception e) {
            throw new RegraNegocioException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<Emprestimo> findAll() {
       return emprestimoDao.findAll();
    }

    @Override
    public void updateEmprestimo(Integer id, EmprestimoPatchDTO emprestimoPatchDTO) {
        Emprestimo emprestimo = this.findById(id);
        emprestimo.setStatus(emprestimoPatchDTO.getStatus());
        emprestimo.setDataDevolucao(emprestimoPatchDTO.getDataDevolucao());
        save(emprestimo);
    }

    public List<Emprestimo> findByIdUsuario(Integer idUsuario){
        return emprestimoDao.findByIdUsuario(idUsuario);
    }
}
