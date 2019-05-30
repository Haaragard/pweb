package br.unisul.pweb.quarta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.pweb.quarta.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	@Transactional(readOnly=true)
	public List<Categoria> findAllByOrderByNome();
	
	List<Categoria> findDistinctByNomeContainingOrderByNome(String nome);
	
}
