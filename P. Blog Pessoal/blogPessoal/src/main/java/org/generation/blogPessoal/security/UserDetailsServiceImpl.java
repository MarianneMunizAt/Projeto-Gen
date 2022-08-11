package org.generation.blogPessoal.security;

import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


//A Classe UserDetailsServiceImpl é uma implementação da Interface UserDetailsService, responsável por validar a existência de um usuário no sistema através do Banco de dados 
//e retornar um Objeto da Classe UserDetailsImpl (implementada no passo anterior), com os dados encontrados no Banco de dados.
//A Interface UserDetailsService permite autenticar um usuário baseando-se na sua existência no Banco de dados (em nosso caso na tabela tb_usuarios). 
//Vale lembrar que para isso é necessário que ao persistir o usuário no Banco de dados, 
//a senha obrigatoriamente deve estar criptografada (Veremos na implementação da Classe UsuarioService),
//utilizando uma biblioteca de criptografia do Spring Security e o usuario (e-mail) deve ser único no sistema,
//ou seja, não podem existir 2 usuários com o mesmo e-mail.

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario(userName);

		if (usuario.isPresent())
			return new UserDetailsImpl(usuario.get());
		else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
	
//O Método loadUserByUsername(String username) recebe o usuário através da tela de login do sistema e utiliza a Query Method findByUsuario(String usuario), 
//implementada na Interface UsuarioRepository,para checar se o usuário digitado está persistido no Banco de dados.
//Caso esteja persistido (isPresent()), ele executa o construtor da Classe UserDetailsImpl,passando o Objeto usuario como parâmetro. 
//Observe que foi utilizado Método get() no Objeto usuario por se tratar de um Optional.
//Caso o usuário não exista, será devolvido o HTTP Status 403 - FORBIDDEN 
//(Acesso Proibido - você está tentando alcançar um endereço ou um site ao qual está proibido de acessar).
}
