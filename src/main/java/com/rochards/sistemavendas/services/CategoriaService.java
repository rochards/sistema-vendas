package com.rochards.sistemavendas.services;

import com.rochards.sistemavendas.domain.Categoria;
import com.rochards.sistemavendas.repositories.CategoriaRepository;
import com.rochards.sistemavendas.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaService {

    private final CategoriaRepository repository;

    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElseThrow(() ->
                new ObjectNotFoundException(String.format("Objeto com id '%d' não encontrado em %s!", id, Categoria.class.getName())));
    }
}
