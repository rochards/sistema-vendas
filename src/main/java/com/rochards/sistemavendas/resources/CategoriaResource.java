package com.rochards.sistemavendas.resources;

import com.rochards.sistemavendas.domain.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaResource {

    @GetMapping
    public List<Categoria> listar() {
        Categoria cat1 = new Categoria(1, "Informática");
        Categoria cat2 = new Categoria(2, "Informática");

        return Arrays.asList(cat1, cat2);
    }
}
