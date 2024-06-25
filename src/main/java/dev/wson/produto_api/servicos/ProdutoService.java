package dev.wson.produto_api.servicos;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.wson.produto_api.modelos.Produto;
import dev.wson.produto_api.modelos.ProdutoDTO;
import dev.wson.produto_api.repositorios.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.save(Produto.converterParaProduto(produtoDTO));
        return ProdutoDTO.converterParaProdutoDTO(produto);
    }
    public List<ProdutoDTO> buscarTodos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos
            .stream()
            .map(ProdutoDTO::converterParaProdutoDTO)
            .collect(Collectors.toList());
    }
    public List<ProdutoDTO> buscarPorCategoria(long categoriaId) {
        List<Produto> produtos = produtoRepository.findProdutosPorCategoria(categoriaId);
        return produtos
            .stream()
            .map(ProdutoDTO::converterParaProdutoDTO)
            .collect(Collectors.toList());
    }
    public ProdutoDTO buscarPorProdutoId(String produtoId) {
        Optional<Produto> produto = produtoRepository.findByProdutoId(produtoId);
        if (produto.isEmpty()) {
            return null;
        }
        return ProdutoDTO.converterParaProdutoDTO(produto.get());
    }
    public boolean excluir(long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            return false;
        }
        produtoRepository.delete(produto.get());
        return true;
    }
}