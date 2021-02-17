package com.rochards.sistemavendas.domain;

import com.rochards.sistemavendas.domain.enums.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PagamentoCartao extends Pagamento {

    private static final long serialVersionUID = 1L;

    private int numeroParcelas;

    public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, int numeroParcelas) {
        super(id, estado, pedido);
        this.numeroParcelas = numeroParcelas;
    }
}
