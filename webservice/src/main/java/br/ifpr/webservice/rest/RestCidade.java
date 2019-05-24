package br.ifpr.webservice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ifpr.webservice.dao.DAOCidade;
import br.ifpr.webservice.entidade.Cidade;

@CrossOrigin
@RestController
@RequestMapping("/ws/cidade/")
public class RestCidade {
	
	@Autowired
	private DAOCidade dao;
	
	@RequestMapping(method=RequestMethod.POST)
	public void salvar(@RequestBody Cidade cidade) {
		dao.save(cidade);
	}
	
	public ResponseEntity<List<Cidade>> buscar(){
		List<Cidade> lista = dao.findAll();
		ResponseEntity<List<Cidade>> resposta = new ResponseEntity<>(lista, HttpStatus.OK);
		return resposta;
		
	}
	
	
}
