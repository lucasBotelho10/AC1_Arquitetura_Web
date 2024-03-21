package com.example.ac1.repositories;

import java.util.List;



import com.example.ac1.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CategoriaProdutoRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    public void excluir(int idCategoria) {
        Categoria categoria = selecionarPorId(idCategoria);
        if (categoria != null) {
            entityManager.remove(categoria);
        }
    }

    public Categoria editar(Categoria categoria) {
        return entityManager.merge(categoria);
    }
    
    public Categoria inserir(Categoria categoria) {
        entityManager.persist(categoria);
        return categoria;
    }

    public List<Categoria> obterTodos() {
        return entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class)
                            .getResultList();
    }

    public Categoria selecionarPorId(int idCategoria) {
        return entityManager.find(Categoria.class, idCategoria);
    }
}


