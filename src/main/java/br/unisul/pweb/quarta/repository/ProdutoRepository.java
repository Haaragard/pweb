package br.unisul.pweb.quarta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.pweb.quarta.domain.Categoria;
import br.unisul.pweb.quarta.domain.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	List<Produto> findDistinctByNomeContainingAndCategoriasIn(
			String nome,
			List<Categoria> categorias
	);
	
}