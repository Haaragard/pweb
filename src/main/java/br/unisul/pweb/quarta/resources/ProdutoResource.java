package br.unisul.pweb.quarta.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unisul.pweb.quarta.domain.Produto;
import br.unisul.pweb.quarta.dtos.ProdutoDTO;
import br.unisul.pweb.quarta.resources.utils.URL;
import br.unisul.pweb.quarta.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> find(
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "categorias", defaultValue = "") String categorias) {

		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categorias);
		List<Produto> list = service.search(nomeDecoded, ids);
		List<ProdutoDTO> listDto = new ArrayList<ProdutoDTO>();
		for (Produto p : list) {
			listDto.add(new ProdutoDTO(p));
		}
		return ResponseEntity.ok().body(listDto);

	}
}