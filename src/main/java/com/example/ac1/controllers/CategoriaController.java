package com.example.ac1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.Categoria;
import com.example.ac1.repositories.CategoriaProdutoRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaProdutoRepository categoriaRepository;
    
    @GetMapping()
    public List<Categoria> obterTodos(){
        return categoriaRepository.obterTodos();
    }

    @PostMapping()
    public void inserir(@RequestBody Categoria categoria){
        categoriaRepository.inserir(categoria);
    }
}
