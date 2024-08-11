package com.elotech.biblioteca.dao.specs;

import com.elotech.biblioteca.entity.Livro;
import org.springframework.data.jpa.domain.Specification;

public abstract class LivroSpecs {

    public static Specification<Livro> tituloLike(String titulo) {
        return (root, query, cb) -> cb.like(root.get("titulo"), "%" + titulo + "%");
    }

    public static Specification<Livro> autorLike(String autor) {
        return (root, query, cb) -> cb.like(root.get("autor"), "%" + autor + "%");
    }

    public static Specification<Livro> isbnEqual(String isbn) {
        return (root, query, cb) -> cb.equal(root.get("isbn"), isbn);
    }

}
