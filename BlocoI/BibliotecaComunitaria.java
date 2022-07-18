package BlocoI;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaComunitaria {

	public static void main(String[] args) {
		
		
		
		int l;
		Scanner leia = new Scanner(System.in);
		//Biblioteca b = new Biblioteca ("nome","autor", "editora", "genero", 0);
		//BibliotecaComunitaria bc = null;

		ArrayList<String> estoque = new ArrayList(); //Collection


		ArrayList<String> estoquel = new ArrayList(); //Collection ACERVO DE LIVROS

		estoquel.add("\n \tR O M A N C E S \n"); 
		estoquel.add("\nUm dia  (David Nicholls)");
		estoquel.add("\nSimplesmente acontece (Cecelia Ahern)");
		estoquel.add("\nComo Eu Era Antes de Você (Jojo Moyes)");
		estoquel.add("\nPs: Eu Te Amo (Cecelia Ahern) \n ");
		estoquel.add("\n \t S U S P E N S E \n");
        estoquel.add("\nMorte no Nilo (Agatha Christie)");
		estoquel.add("\nOs Homens Que Não Amavam As Mulheres (Stieg Larsson)");
		estoquel.add("\nIlha do Medo (Dennis Lehane) \n ");
		estoquel.add ("\n \t L I T E R A T U R A\n ");
		estoquel.add("\nDom Casmurro ( Machado de Assis)");
		estoquel.add("\nO Cortiço ( Aluísio Azevedo)");
		estoquel.add("\nMemórias Póstumas de Brás Cubas(Machado de Assis)");
		estoquel.add("\nA moreninha (Joaquim Manuel de Macedo)");                    
		

		
		System.out.println(":: S I S T E M A  D E  B I B L I O T E C A ::");
		System.out.println();
		System.out.println("Bem-vinde(s) ao sistema:");
		System.out.println();
   
		System.out.println("Coloque seu nome: ");
		String usuario = leia.nextLine();
		System.out.println("Coloque seu e-mail: ");
		String Email = leia.nextLine();


//MENU
		do 
		{
			System.out.println("--------------------");
			System.out.println();
			System.out.println("--------MENU-----------");

			System.out.println("\n (1) Deseja doar livros.");
			System.out.println("\n (2) Deseja retirar qual livro?");
			System.out.println("\n (3) Deseja trocar seu livro com algum livro do estoque?");
			System.out.println("\n (4) Deseja mostrar todos os produtos do estoque.");
			System.out.println("\n (0) Deseja encerrar o programa.");
			System.out.println("\n Digite a sua opção: ");
			l = leia.nextInt();


			switch(l)

			{

			case 1: //DOAÇÃO

				leia.nextLine(); //NEXTLINE - USOU PARA LIMPAR
				System.out.println("\n Digite o nome do livro que deseja doar: ");
				String livros = leia.nextLine();// NEXTLINE - PARA LER UMA COISA TIPO STRING
				System.out.println("\n Qual o gênero do seu livro?");
				String genero = leia.nextLine();
				System.out.println("\n Qual o autor do seu livro?");
				String autor = leia.nextLine();
				System.out.println("\n Qual a editora do seu livro?");
				String editora = leia.nextLine();
				System.out.println("\n Escreva um código para o seu livro: ");
				int codigoDoLivro = leia.nextInt();
				estoquel.add(livros); //USUARIO VAI ESCREVER E AQ VAI ADICIONAR AO ESTOQUE

				leia.nextLine(); //NEXTLINE - USOU PARA LIMPAR

//------MENSAGEM AO USUARIO			
				System.out.println("PARABÉNS, "+ usuario +"."+" Você acabou de doar para nossa Biblioteca. \n O livro: \n" + livros +" autor:" + autor);   
				System.out.println("\n Enviamos um comprovante para o seu e-mail : "+ Email+"!");
				
				break;


			case 2 : //RETIRAR

				leia.nextLine();
				System.out.println(estoquel); //MOSTRAR O ACERVO DE LIVROS PARA VISUALIZAÇÃO
				leia.nextLine(); 

				System.out.println("\n Digite o nome do livro que quer retirar do estoque: ");
				String livro = leia.nextLine();

				if(estoquel.contains(livro)) // VER SE EXISTE DETERMINADO LIVRO PARA REMOVER
				{
					estoquel.remove(livro);
				}
				
			// ----- MENSAGEM	
				System.out.println("\n"+ usuario+ ","+ " Produto removido com sucesso!!"+ "\n Você retirou o livro :" + livro + "\n Seu prazo de entrega é de 30 dias!!!");
				System.out.println("\n Enviamos um comprovante para o seu e-mail:" + Email+"!");
				
				break;

				
			case 3: //TROCAR
				//QUAL PRODUTO VAI TIRAR E QUAL VAI COLOCAR

				leia.nextLine();
				System.out.println(estoquel); //MOSTRAR O ESTOQUE DE LIVROS PARA VISUALIZAÇÃO
				leia.nextLine(); 
				System.out.println("\n Digite o nome dolivro que você quer trocar do estoque: ");
				String verifica = leia.nextLine();
				System.out.println("\n Digite o nome do livro que vai entrar no lugar do " +verifica+ " : ");
				String novo = leia.nextLine();

				//VERIFICA SE TEM O PRODUTO 

				if(estoquel.contains(verifica)) //CONTAINS - VER SE EXISTE DETERMINADO PRODUTO PARA REMOVER
				{
					estoquel.remove(verifica);
					estoquel.add(novo);
				}
				else //SE NÃO TIVER
				{
					System.out.println("\n Produto Indisponivel no momento!!");
				}

				
// MENSAGEM AO USUARIO
				
				System.out.println("\n"+ usuario +","+ "sua troca foi realizada!!! \n Você realizou a troca do livro:" + novo + "\n Pelo livro :" + verifica);
                System.out.println("Enviamos um comprovante para o seu e-mail:" + Email);
                
		//MOSTRAR A LISTA DNV PARA VER SE ATUALIZOU
				System.out.println(estoquel); 
				break;



			case 4: //MOSTRAR

					System.out.println("\n Os livros no estoque são: ");
					System.out.println();
					System.out.print(estoquel); //MOSTRAR ESTOQUE
					System.out.println();
					break;

			case 0: 
					System.out.println("\n Programa Finalizado!!");
					System.out.println();
					System.out.println("\n Volte sempre!");
					break;

					default : //EXEÇÃO

				System.out.println("Erro! Opção Indisponivel");
			}
		}

		while(l!=0); //ENQUANTO DIFERENTE DE 0 VAI SAIR

	}

}
