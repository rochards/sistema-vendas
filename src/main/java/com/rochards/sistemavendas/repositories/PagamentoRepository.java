package com.rochards.sistemavendas.repositories;

import com.rochards.sistemavendas.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
