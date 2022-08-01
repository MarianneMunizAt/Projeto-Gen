package org.generation.blogPessoal.controller;


import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.repository.cdi.CdiRepositoryExtensionSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;


@RestController // ESSA CLASSE É UM CONTROLADOR
@RequestMapping("/postagens")
@CrossOrigin("*") //ESSA CLASSE VAI RECEBER REQUISIÇÕES DE QUALQUER ORIGEM
//FAZ LIGAÇÃO COM O FRONT-END


public class PostagemController {

	// CLASSE DE REPOSITORIO
	
	@Autowired // PODE SER ACESSADO A PARTIR DO CONTROLLER
	private PostagemRepository repository;
	
	// METODO
	@GetMapping //SEMPRE QUE HOUVER UMA REQUESIÇÃO EXTERNA - SE O METODO FOR GET ELE VAI DISPARAR O METODO ABAIXO
	public ResponseEntity<List<Postagem>>  GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
		
	}
}
