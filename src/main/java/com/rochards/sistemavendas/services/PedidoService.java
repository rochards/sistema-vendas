package com.rochards.sistemavendas.services;

import com.rochards.sistemavendas.domain.Pedido;
import com.rochards.sistemavendas.repositories.PedidoRepository;
import com.rochards.sistemavendas.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PedidoService {

    private final PedidoRepository repository;

    public Pedido buscarPorId(Integer id) {
        Optional<Pedido> cliente = repository.findById(id);
        return cliente.orElseThrow(() ->
                new ObjectNotFoundException(String.format("Objeto com id '%d' não encontrado em %s!", id, Pedido.class.getName())));
    }
}
