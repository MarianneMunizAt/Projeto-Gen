package org.generation.blogPessoal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.CdiRepositoryExtensionSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;


@RestController // ESSA CLASSE É UM CONTROLADOR
@RequestMapping("/postagens")

@CrossOrigin("*")	 //FORMA ABREVIADA

//@CrossOrigin(origins = "*", allowedHeaders = "*") //ESSA CLASSE VAI RECEBER REQUISIÇÕES DE QUALQUER ORIGEM
//FAZ LIGAÇÃO COM O FRONT-END


public class PostagemController {

//CLASSE DE REPOSITORIO
	
	@Autowired // PODE SER ACESSADO A PARTIR DO CONTROLLER
	private PostagemRepository repository;
	
	// METODO
	@GetMapping //SEMPRE QUE HOUVER UMA REQUESIÇÃO EXTERNA - SE O METODO FOR GET ELE VAI DISPARAR O METODO ABAIXO
	public ResponseEntity<List<Postagem>>  GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
//ACHAR ALGO PELO ID
	
	@GetMapping("/{id}")
	 										//VARIAVEL QUE VAI RECEBER
	public ResponseEntity<Postagem> GetById(@PathVariable long id) //PATH = É USANDO QUANDO QUEREMOS PASSAR UM VALOR PELA URL 
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
//TE DEVOLVER UM OBJETO TANTO COMO POSTAGEM COMO UMA RESPOSTA SE HOUVER ALGUM ERRO NA REQUISIÇÃO
	}
	
	
//ACHAR ALGO PELO TITULO
	
				//
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List <Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	
	@PostMapping					 // @Valid
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable long id){
		repository.deleteById(id);
	}
}
