package com.elotech.biblioteca.converter;

import com.elotech.biblioteca.dto.EmprestimoDTO;
import com.elotech.biblioteca.dto.LivroDTO;
import com.elotech.biblioteca.entity.Emprestimo;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.util.DateUtil;
import com.elotech.biblioteca.util.StringUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class EmprestimoConverter {

    public static final DateTimeFormatter DATE_FORMATTER_AMERICANO = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @Autowired
    private ModelMapper modelMapper;

    public EmprestimoDTO toDto(Emprestimo emprestimo) {
        EmprestimoDTO emprestimoDTO =  modelMapper.map(emprestimo, EmprestimoDTO.class);

        if (emprestimo.getDataEmprestimo() != null) {
            emprestimoDTO.setDataEmprestimo(DateUtil.localDateToString(emprestimo.getDataEmprestimo()));
        }

        if (emprestimo.getDataDevolucao() != null) {
            emprestimoDTO.setDataDevolucao(DateUtil.localDateToString(emprestimo.getDataDevolucao()));
        }

        return emprestimoDTO;
    }

    public Emprestimo toEntity(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo =  modelMapper.map(emprestimoDTO, Emprestimo.class);

        if(emprestimoDTO.getDataDevolucao() != null){
            emprestimo.setDataDevolucao(DateUtil.stringToLocalDate(emprestimoDTO.getDataDevolucao(),DATE_FORMATTER_AMERICANO));
        }

        if(emprestimoDTO.getDataEmprestimo() != null){
            emprestimo.setDataEmprestimo(DateUtil.stringToLocalDate(emprestimoDTO.getDataEmprestimo(),DATE_FORMATTER_AMERICANO));
        }
        return  emprestimo;

    }
}
