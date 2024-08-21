package dev.wson.produto_api.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.wson.produto_api.modelos.ProdutoDTO;
import dev.wson.produto_api.servicos.ProdutoService;
import jakarta.validation.Valid;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produto")
    public ProdutoDTO salvar(@Valid @RequestBody ProdutoDTO produto) {
        return produtoService.salvar(produto);
    }
    @GetMapping("/produto")
    public List<ProdutoDTO> buscarTodos() {
        return produtoService.buscarTodos();
    }
    @GetMapping("/produto")
    public List<ProdutoDTO> buscarPorCategoria(@RequestParam(name = "categoriaId", required = true) long categoriaId) {
        return produtoService.buscarPorCategoria(categoriaId);
    }
    @GetMapping("/produto/{produtoId}")
    public ProdutoDTO buscarPorProdutoId(@PathVariable String produtoId) {
        return produtoService.buscarPorProdutoId(produtoId);
    }
    @DeleteMapping("/usuario/{id}")
    public void excluir(@PathVariable long id) {
        produtoService.excluir(id);
    }
}