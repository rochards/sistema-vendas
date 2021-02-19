package com.rochards.sistemavendas.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rochards.sistemavendas.domain.enums.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // significa que terei uma tabela para cada subclasse
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private Integer estado;

    @JsonBackReference
    @OneToOne
    @MapsId // essa anotacao faz com q o id de Pagamento seja o mesmo do Pedido
    @JoinColumn(name = "pedido_id") // na tabela Pagamento ficara o id do Pedido
    private Pedido pedido;

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado.getCod();
        this.pedido = pedido;
    }

    public EstadoPagamento getEstado() {
        return EstadoPagamento.toEnum(estado);
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado.getCod();
    }
}
