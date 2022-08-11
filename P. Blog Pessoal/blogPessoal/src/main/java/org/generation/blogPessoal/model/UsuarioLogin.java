package org.generation.blogPessoal.model;

//A Classe UsuarioLogin é responsável por definir que o cliente ao tentarr (fazer login) no sistema autentica, 
//fornecendo apenas o usuário (e-mail) e senha. Essa Classe também pode ser definida como um DTO ( Data trasfer object ),
//que é uma Classe que é utilizada para transitar dados do sistema sem revelar sua Classe Model para o cliente.

public class UsuarioLogin {
	
	private Long id;
	private String nome;
	private String usuario;
	private String senha;
	private String foto;
	private String token;
	
	//ALERTA : o Atributo token, pois o mesmo será passado no cabeçalho de todas as requisições que do front-end.
	//Este Atributo é fundamental para o funcionamento do consumo da api.
	
//GETTERS AND SETTERS 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
