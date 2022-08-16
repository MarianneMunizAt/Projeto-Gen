package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


//A Classe UsuarioRepositoryTest foi utilizada para testar a Classe Repository do Usuario.

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //Indica que a Classe UsuarioRepositoryTest é uma Classe Spring Boot Testing. A Opção de ambiente indica que caso a porta principal (8080 para uso local) seja ocupada, o Spring assina uma outra porta automaticamente.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)//ndica que o Ciclo de vida da Classe de Teste será por Classe.
public class UsuarioRepositoryTest {


	
	@Autowired   //um objeto da Interface UsuarioRepository para persistir os objetos no Banco de dados de testes.
	
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll // apaga os dados da tabela
	void start(){

		usuarioRepository.deleteAll();

		usuarioRepository.save(new Usuario(0L, "João da Silva", "joao@email.com.br", "13465278", "https://i.imgur.com/FETvs2O.jpg"));
		
		usuarioRepository.save(new Usuario(0L, "Manuela da Silva", "manuela@email.com.br", "13465278", "https://i.imgur.com/NtyGneo.jpg"));
		
		usuarioRepository.save(new Usuario(0L, "Adriana da Silva", "adriana@email.com.br", "13465278", "https://i.imgur.com/mB3VM2N.jpg"));

        usuarioRepository.save(new Usuario(0L, "Paulo Antunes", "paulo@email.com.br", "13465278", "https://i.imgur.com/JR7kUFU.jpg"));

	}
	
		//Método 01 - Retornar um Usuário
	
	@Test //indica que este método executará um teste.
	@DisplayName("Retorna 1 usuario") //Configura uma mensagem que será exibida ao invés do nome do método
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br"); //o objeto usuário recebe o resultado do Método findByUsuario ()

		assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
	}

	//Método 02 - Retornar três usuários
	
	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");

		assertEquals(3, listaDeUsuarios.size());
		
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
		
	}

	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
}
