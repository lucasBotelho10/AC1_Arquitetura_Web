package com.example.ac1.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produtos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProdutoRepository  {

     @PersistenceContext
    private EntityManager entityManager;
    
    public void excluir(int idProduto) {
        Produtos produto = selecionarPorId(idProduto);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }
    public Produtos editar(Produtos produto) {
        return entityManager.merge(produto);
    }

    public Produtos inserir(Produtos produto) {
        entityManager.persist(produto);
        return produto;
    }

    public List<Produtos> obterTodos() {
        return entityManager.createQuery("SELECT p FROM Produtos p", Produtos.class)
                            .getResultList();
    }

    public Produtos selecionarPorId(int idProduto) {
        return entityManager.find(Produtos.class, idProduto);
    }

}
