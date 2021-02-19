package com.rochards.sistemavendas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
    Nao vou serializar o id, assim nao chama o Produto e nem o Pedido, por isso anotei com @JsonIgnore.
    Dessa forma eu nao preciso me preocupar com as anotacoes @JsonManagedReference e @JsonBackReference
    */
    @JsonIgnore
    @EmbeddedId
    @EqualsAndHashCode.Include
    private ItemPedidoPK id;
    private double desconto;
    private int quantidade;
    private double preco;

    public ItemPedido(Pedido pedido, Produto produto, double desconto, int quantidade, double preco) {
        this.id = new ItemPedidoPK();
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public Produto getProduto() {
        return id.getProduto();
    }
}
