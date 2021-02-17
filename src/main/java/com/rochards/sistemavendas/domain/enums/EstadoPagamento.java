package com.rochards.sistemavendas.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoPagamento {

    PENDENTE(1),
    QUITADO(2),
    CANCELADO(3);

    private final int cod;

    public static EstadoPagamento toEnum(int cod) {
        for (var estado : EstadoPagamento.values()) {
            if (cod == estado.getCod()) return estado;
        }
        throw new IllegalArgumentException(String.format("Código '%d' inválido!", cod));
    }
}
