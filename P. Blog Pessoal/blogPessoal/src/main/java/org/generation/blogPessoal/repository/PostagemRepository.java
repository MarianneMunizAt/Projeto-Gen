package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	// IMPORTA LIST DO 'java.util'
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
														//(@Param ("titulo") String titulo)
																		
																	//CERTO A SE FAZER^^^^
}
