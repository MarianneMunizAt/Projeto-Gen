package org.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//TEXTOS MENORES É PRA USAR @NOTBLANCK
//TEXTOS MAIORES @NOTNULL


@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	// L MAIUSCULO DO LONG
	
	@NotBlank(message = "O atributo descrição é obrigatorio! E não pode utilzar espaços em branco.")
	private String descricao;

	
//RELACIONAMENTO COM POSTAGENS
	
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL) //MAPEAR AS POSTAGENS PARA QUE NÃO SUMAM 
	@JsonIgnoreProperties("tema") //PARA EVITAR RECURSIDVIDADE (RECURSIVIDADE = QUANDO TRAZ AS CAMADAS EM RELACIONAMENTO 2X)
	private List<Postagem> postagem;//OQ VAI VIR NO TEMA
	
	
//GETTERS AND SETTERS
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}
