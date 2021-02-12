package com.rochards.sistemavendas.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private Double preco;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "produto_categoria", // tabela de relacionamento
            joinColumns = @JoinColumn(name = "produto_id"), // FK desta entidade na tabela produto_categoria
            inverseJoinColumns = @JoinColumn(name = "categoria_id")) // FK da outra entidade na tabela produto_categoria
    private List<Categoria> categorias;

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categorias = new ArrayList<>();
    }
}
