package com.rochards.sistemavendas.domain;

import com.rochards.sistemavendas.domain.enums.EstadoPagamento;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PagamentoBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;

    private LocalDateTime vencimento;
    private LocalDateTime pagamento;

    public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, LocalDateTime vencimento, LocalDateTime pagamento) {
        super(id, estado, pedido);
        this.vencimento = vencimento;
        this.pagamento = pagamento;
    }
}
