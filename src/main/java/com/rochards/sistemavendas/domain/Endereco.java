package com.rochards.sistemavendas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    @ManyToOne // um cliente tem muitos enderecos
    @JoinColumn(name = "cliente_id") // definindo a FK que ficara na tabela Cliente
    private Cliente cliente;

    @ManyToOne // uma cidade tem varios enderecos
    @JoinColumn(name = "cidade_id") // definindo a FK que ficara na tabela Cliente
    private Cidade cidade;
}
