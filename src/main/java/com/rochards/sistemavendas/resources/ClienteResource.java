package com.rochards.sistemavendas.resources;

import com.rochards.sistemavendas.domain.Cliente;
import com.rochards.sistemavendas.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteResource {

    private final ClienteService service;

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
        var cliente = service.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }
}
