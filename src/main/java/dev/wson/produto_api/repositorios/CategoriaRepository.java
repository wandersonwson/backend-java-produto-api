package dev.wson.produto_api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.wson.produto_api.modelos.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}