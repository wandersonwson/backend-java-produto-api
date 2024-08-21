package dev.wson.produto_api.modelos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoriaDTO {
    @NotNull
    private Long id;
    private String nome;

    public static CategoriaDTO converterParaCategoriaDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNome(categoria.getNome());
        return categoriaDTO;
    }
}