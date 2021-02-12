package com.rochards.sistemavendas;

import com.rochards.sistemavendas.domain.Categoria;
import com.rochards.sistemavendas.domain.Cidade;
import com.rochards.sistemavendas.domain.Estado;
import com.rochards.sistemavendas.domain.Produto;
import com.rochards.sistemavendas.repositories.CategoriaRepository;
import com.rochards.sistemavendas.repositories.CidadeRepository;
import com.rochards.sistemavendas.repositories.EstadoRepository;
import com.rochards.sistemavendas.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SistemaVendasApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaVendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto prod1 = new Produto(null, "Computador", 2000.0);
		Produto prod2 = new Produto(null, "Impressora", 800.0);
		Produto prod3 = new Produto(null, "Mouse", 80.0);

		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod1, prod2));

		prod1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().add(cat1);

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

		Estado est1 = new Estado(null, "Minas Gerias", "MG");
		Estado est2 = new Estado(null, "São Paulo", "SP");
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);

		est1.getCidades().add(cid1);

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.save(cid1);
	}
}
