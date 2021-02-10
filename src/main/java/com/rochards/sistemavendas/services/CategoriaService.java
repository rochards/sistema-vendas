package com.rochards.sistemavendas.services;

import com.rochards.sistemavendas.domain.Categoria;
import com.rochards.sistemavendas.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaService {

    private final CategoriaRepository repository;

    public Categoria buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
