package com.rochards.sistemavendas.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/*
Classe criada para ser o chave primaria da relacao da Entidade ItemPedido. Lembre-se que ItemPedido
eh uma classe de associacao, por isso nao possui id proprio/independente
*/

@Data
@Embeddable
public class ItemPedidoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
