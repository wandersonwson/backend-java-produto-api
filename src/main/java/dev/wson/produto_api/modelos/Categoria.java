package dev.wson.produto_api.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
}