package com.rochards.sistemavendas.resources;

import com.rochards.sistemavendas.domain.Pedido;
import com.rochards.sistemavendas.services.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PedidoResource {

    private final PedidoService service;

    @GetMapping("{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id) {
        var pedido = service.buscarPorId(id);
        return ResponseEntity.ok(pedido);
    }
}
