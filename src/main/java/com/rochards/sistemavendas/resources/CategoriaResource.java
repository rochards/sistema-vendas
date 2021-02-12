package com.rochards.sistemavendas.resources;

import com.rochards.sistemavendas.domain.Categoria;
import com.rochards.sistemavendas.services.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaResource {

    private final CategoriaService service;

    @GetMapping("{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
        var categoria = service.buscarPorId(id);
        return ResponseEntity.ok(categoria);
    }
}
