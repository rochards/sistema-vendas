package com.rochards.sistemavendas.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurírica");

    private final int cod;
    private final String descricao;

    public static TipoCliente toEnum(int cod) {
        for (TipoCliente tipo: TipoCliente.values()) {
            if (cod == tipo.getCod()) return tipo;
        }
        throw new IllegalArgumentException(String.format("Código '%d' inválido!", cod));
    }
}
