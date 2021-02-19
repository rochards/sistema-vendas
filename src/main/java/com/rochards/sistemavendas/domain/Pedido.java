package com.rochards.sistemavendas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime instante;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    /*
    Essa associacao aqui eh direcionada (ver o digrama de classes), assim nao tem anotacao
    @OneToMany na entidade Endereco, por isso nao preciso me preocupar com @JsonManagedReference
    */
    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    private Endereco enderecoEntrega;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens;

    public Pedido(Integer id, LocalDateTime instante, Pagamento pagamento, Endereco enderecoEntrega, Cliente cliente) {
        this.id = id;
        this.instante = instante;
        this.pagamento = pagamento;
        this.enderecoEntrega = enderecoEntrega;
        this.cliente = cliente;
        this.itens = new HashSet<>();
    }

    @JsonIgnore
    public List<Produto> getProdutos() {
        return itens.stream().map(ItemPedido::getProduto).collect(Collectors.toList());
    }
}
