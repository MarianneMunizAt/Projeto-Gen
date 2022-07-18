package BlocoI;

import java.util.ArrayList;

public class Biblioteca {

	private String nome;
	private String genero;
	private String autor;
	private String editora;
	private int codigoDoLivro;
	
//CONSTRUTOR
	
	Biblioteca (String nome,String genero, String autor, String editora, int codigoDoLivro)
	{
		this.nome = nome;
		this.genero = genero;
		this.autor = autor;
		this.editora = editora;
		this.codigoDoLivro = codigoDoLivro;
	}
	
//METODOS 
	
	public void estado()
	{
		System.out.println("O nome do livro é: " + this.nome);
		System.out.println("Genero é: " + this.genero);
		System.out.println("O autor é: " + this.autor);
		System.out.println("A  editora é: " + this.editora );
		System.out.println("O cógido do livro é: " + this.codigoDoLivro);
	}
	
	
		public void estoquel()
	{
			System.out.println("\n A Culpa das Estrelas");
			System.out.println("\n Guerra dos Tronos");
			System.out.println("\n Harry Potter e a Pedra Filosofal");
			System.out.println("\n A Paciente Silenciosa");
			System.out.println("\n Morada da Noite");
			System.out.println("\n A garota que roubava livros");
	}
		
//Getters and Setters 

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public String getEditora() {
			return editora;
		}

		public void setEditora(String editora) {
			this.editora = editora;
		}

		public int getCodigoDoLivro() {
			return codigoDoLivro;
		}

		public void setCodigoDoLivro(int codigoDoLivro) {
			this.codigoDoLivro = codigoDoLivro;
		}
	
	
	
	
}
