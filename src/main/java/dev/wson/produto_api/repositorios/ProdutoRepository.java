package dev.wson.produto_api.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import dev.wson.produto_api.modelos.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query(value = "select p from produto p join categoria c on p.categoria.id = c.id where c.id = :categoriaId")
    public List<Produto> findProdutosPorCategoria(@Param("categoriaId") long categoriaId);
    public Produto findByProdutoId(String produtoId);
}