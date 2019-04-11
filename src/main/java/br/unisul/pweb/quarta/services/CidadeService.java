package br.unisul.pweb.quarta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.quarta.domain.Cidade;
import br.unisul.pweb.quarta.repository.CidadeRepository;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository rep;
	

	public List<Cidade> findByEstado(Integer estadoId) {
		return rep.findCidades(estadoId);
	}
}