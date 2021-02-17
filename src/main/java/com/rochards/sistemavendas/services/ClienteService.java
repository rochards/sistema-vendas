package com.rochards.sistemavendas.services;

import com.rochards.sistemavendas.domain.Cliente;
import com.rochards.sistemavendas.repositories.ClienteRepository;
import com.rochards.sistemavendas.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

    private final ClienteRepository repository;

    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() ->
                new ObjectNotFoundException(String.format("Objeto com id '%d' não encontrado em %s!", id, Cliente.class.getName())));
    }
}
