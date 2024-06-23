package dev.wson.produto_api.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Float preco;
    @Column(name = "produto_id", nullable = false)
    private String produtoId;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}