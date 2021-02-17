package com.rochards.sistemavendas.repositories;

import com.rochards.sistemavendas.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
