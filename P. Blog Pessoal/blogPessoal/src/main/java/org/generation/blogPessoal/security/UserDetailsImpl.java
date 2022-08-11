package org.generation.blogPessoal.security;

import java.util.Collection;
import java.util.List;



import org.generation.blogPessoal.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//A Classe UserDetailsImpl implementa a Interface UserDetails, que tem como principal funcionalidade fornecer 
//as informações básicas do usuário para o Spring Security (Usuário, Senha, Direitos de acesso e as Restrições da conta).
//Após a autenticação (login) do usuário no sistema, a Classe de Serviço UserDetailsServiceImpl 
//instanciará um novo Objeto da Classe UserDetailsImpl com os respectivos Atributos preenchidos com os dados do usuário autenticado (usuario e senha).
//Este Objeto também conterá todos os Métodos herdados da Interface UserDetails, que consultam os Direitos de acesso (roles) 
//e implementam as restrições da conta do usuário.

public class UserDetailsImpl implements UserDetails {

private static final long serialVersionUID =1L;
	
	private String userName;
	private String password;
	
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl (Usuario user){
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	public UserDetailsImpl (){ }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

	return authorities;
	}

	@Override
	public String getPassword() {

	return password;
	}

	@Override
	public String getUsername() {
	
	return userName;
	}

	@Override
	public boolean isAccountNonExpired() { //Indica se a conta do usuário expirou. Uma conta expirada não pode ser autenticada (return false).
	
	return true;
	}

	@Override
	public boolean isAccountNonLocked() { //Indica se o usuário está bloqueado ou desbloqueado. Um usuário bloqueado não pode ser autenticado (return false).
	
	return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { //Indica se as credenciais do usuário (senha) expiraram. Senha expirada impede a autenticação (return false).
	
	return true;
	}

	@Override
	public boolean isEnabled() { //Indica se o usuário está habilitado ou desabilitado. Um usuário desabilitado não pode ser autenticado (return false).
	
	return true;
	}

}
