package org.generation.blogPessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//TEXTOS MENORES É PRA USAR @NOTBLANCK
//TEXTOS MAIORES @NOTNULL


@Entity
@Table(name = "tb_postagem") // QUE VAI CRIAR UMA TABELA NO BANCO DE DADOS CHAMADA POSTAGENS
public class Postagem {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	// L MAIUSCULO DO LONG
	
	@NotNull
	@Size (min = 5 , max = 100) 	//O atributo título deve conter no mínimo 05 e no máximo 100 caracteres
	private String titulo;
	
	
	@NotNull 						//O atributo título é Obrigatório e não pode utilizar espaços em branco 
	@Size (min = 10 , max = 500)
	private String texto;
	
	// --------------------FORMA DE FAZER ATRASADA ----------------------------------------
	//@Temporal(TemporalType.TIMESTAMP) //AQUI A PESSOAL TEM QUE INSERIR A DATA, ANO, TEMPO
	//@NotNull
	//private Date date = new java.sql.Date(System.currentTimeMillis());
	//-----------------------FORMA ATRASADA ------------------------------------------------
	
	
//FORMA CERTA DE COLOCAR TEMPO - VAI AUTOMATICO, A PESSOA NÃO PRECISA ESCREVER
	@UpdateTimestamp					
	private LocalDateTime data; 		


// RELACIONAMENTO COM TEMA
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

//RELACIONAMENTO COM USUARIO
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	

//GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
}

	
