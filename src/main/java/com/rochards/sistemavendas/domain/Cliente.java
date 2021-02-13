package com.rochards.sistemavendas.domain;

import com.rochards.sistemavendas.domain.enums.TipoCliente;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo; // no diagrama de classes isso eh um Enum. Estamos fazendo isso para salvar o valor no banco de dados

    // um cliente possui varios enderecos
    @OneToMany(mappedBy = "cliente") // indicando que na classe Endereco tem um atributo cliente que faz a associacao
    private List<Endereco> enderecos;

    @ElementCollection
    @CollectionTable(name = "telefone") // vai existir uma tabela chamada telefone
    private Set<String> telefones; // no diagrama de classes esse dado eh uma entidade fraca

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo.getCod();
        this.enderecos = new ArrayList<>();
        this.telefones = new HashSet<>();
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(this.tipo);
    }
}
