package dev.wson.produto_api.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dev.wson.produto_api.modelos.ProdutoDTO;
import dev.wson.produto_api.servicos.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoDTO salvar(@Valid @RequestBody ProdutoDTO produto) {
        return produtoService.salvar(produto);
    }
    @GetMapping
    public List<ProdutoDTO> buscarTodos() {
        return produtoService.buscarTodos();
    }
    @GetMapping("/{categoriaId}")
    public List<ProdutoDTO> buscarPorCategoria(@RequestParam(name = "categoriaId", required = true) long categoriaId) {
        return produtoService.buscarPorCategoria(categoriaId);
    }
    @GetMapping("/{produtoId}")
    public ProdutoDTO buscarPorProdutoId(@PathVariable String produtoId) {
        return produtoService.buscarPorProdutoId(produtoId);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable long id) {
        produtoService.excluir(id);
    }
}