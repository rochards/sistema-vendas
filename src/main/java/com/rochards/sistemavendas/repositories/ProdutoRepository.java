package com.rochards.sistemavendas.repositories;

import com.rochards.sistemavendas.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
