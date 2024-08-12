package com.elotech.biblioteca.service.impl;

import com.elotech.biblioteca.dao.LivroDao;
import com.elotech.biblioteca.dao.specs.LivroSpecs;
import com.elotech.biblioteca.entity.enums.Categoria;
import com.elotech.biblioteca.entity.Livro;
import com.elotech.biblioteca.exception.CustomException;
import com.elotech.biblioteca.service.LivroService;
import com.elotech.biblioteca.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    LivroDao livroDao;

    @Override
    public Livro findById(Integer id) {
        return livroDao.findById(id).orElseThrow(() ->
                new CustomException(HttpStatus.NOT_FOUND,
                        "Livro não encontrado"));
    }

    @Override
    public Livro save(Livro livro) {
        try {
            livro.setIsbn(StringUtil.somenteNumeros(livro.getIsbn()));
            if(livro.getId() == null) {
                livroDao.findByIsbn(livro.getIsbn()).ifPresent((l) -> {
                    throw new CustomException(HttpStatus.BAD_REQUEST,
                            "ISBN já cadastrado");
                });
            }
            return livroDao.save(livro);
        }catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<Livro> findAll() {
        return livroDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        try {
            livroDao.deleteById(id);
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    public Optional<Livro> findByIsbn(String isbn){
        return livroDao.findByIsbn(isbn);
    }

    @Override
    public Page<Livro> findAll(String titulo, String autor, String isbn, Pageable pageable) {
        Specification<Livro> livroSpecification = Specification
                .where(titulo != null ? LivroSpecs.tituloLike(titulo) : null)
                .and(autor != null ? LivroSpecs.autorLike(autor) : null)
                .and(isbn != null ? LivroSpecs.isbnEqual(isbn) : null);
        return livroDao.findAll(livroSpecification, pageable);
    }

    public List<Livro> getByCategoria(List<Categoria> listCategoria){
        return livroDao.getByCategoria(listCategoria);
    }
}
