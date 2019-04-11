package br.unisul.pweb.quarta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.pweb.quarta.domain.Cliente;
import br.unisul.pweb.quarta.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	
	@Transactional(readOnly=true)
	List<Pedido> findByCliente(Cliente cliente);
}
