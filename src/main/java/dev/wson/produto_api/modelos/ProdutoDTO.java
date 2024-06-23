package dev.wson.produto_api.modelos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoDTO {
    @NotBlank
    private String produtoId;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Float preco;
    @NotNull
    private CategoriaDTO categoriaDTO;

    public static ProdutoDTO converterParaProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setProdutoId(produto.getProdutoId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setDescricao(produto.getDescricao());
        if (produto.getCategoria() != null) {
            produtoDTO.setCategoriaDTO(
                CategoriaDTO.converterParaCategoriaDTO(produto.getCategoria())
            );
        }
        produtoDTO.setPreco(produto.getPreco());
        return produtoDTO;
    }
}