package com.example.ac1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produtos;
import com.example.ac1.repositories.CategoriaProdutoRepository;
import com.example.ac1.repositories.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Ac1Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProdutoRepository produtoRepository, CategoriaProdutoRepository categoriaRepository) {
        return args -> {
       
            Categoria categoria1 = new Categoria();
            categoria1.setNome("Eletrônicos");
            categoria1.setDescricao("Produtos eletrônicos");
            categoriaRepository.inserir(categoria1);

            Categoria categoria2 = new Categoria();
            categoria2.setNome("Limpeza");
            categoria2.setDescricao("Produtos de limpeza");
            categoriaRepository.inserir(categoria2);

            Produtos produto1 = new Produtos();
            produto1.setNome("Computador");
            produto1.setQuantidade(20);
            produto1.setCategoria(categoria1);
            produtoRepository.inserir(produto1);

            Produtos produto2 = new Produtos();
            produto2.setNome("Amaciante");
            produto2.setQuantidade(10);
            produto2.setCategoria(categoria2);
            produtoRepository.inserir(produto2);

    
System.out.println("Produtos:");
for (Produtos produto : produtoRepository.obterTodos()) {
    System.out.println(produto.getId() + " - " + produto.getNome() + " - " + produto.getQuantidade() + " - " + produto.getCategoria().getNome());
}

System.out.println("\nCategorias:");

for (Categoria categoria : categoriaRepository.obterTodos()) {
    System.out.println(categoria.getId() + " - " + categoria.getNome() + " - " + categoria.getDescricao());
}
   };
  }
}
