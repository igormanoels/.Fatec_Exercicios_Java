package edu.dio.exercicio09;

import javax.swing.JOptionPane;

import edu.dio.exercicio08.ContagemPalavras;

/*
 * Livraria Online
 * Crie uma classe chamada "LivrariaOnline" que representa uma livraria online. 
 * Essa classe utiliza um Map para armazenar os livros disponíveis na livraria, 
 * utilizando o link da obra na Amazon Marketplace como chave e um objeto da 
 * classe "Livro" como valor. A classe "Livro" possui atributos como título, 
 * autor e preço. Através da classe "LivrariaOnline", 
 * 
 * implemente os seguintes métodos:
 * - adicionarLivro(String link, String titulo, String autor, private double preco): Adiciona um livro à livraria, utilizando o ISBN como chave no Map.
 * - removerLivro(String titulo): Remove um livro da livraria, dado o titulo do livro.
 * - exibirLivrosOrdenadosPorPreco(): Exibe os livros da livraria em ordem crescente de preço.
 * - pesquisarLivrosPorAutor(String autor): Retorna uma lista de todos os livros escritos por um determinado autor.
 * - obterLivroMaisCaro(): Retorna o livro mais caro disponível na livraria.
 * - exibirLivroMaisBarato(): Retorna o livro mais barato disponível na livraria.
 */
public class Principal 
{
	public static void main(String[]args) 
	{
		int op;
		String link, titulo, autor;
		double preco;
		boolean continuar = true;
		
		LivrariaOnline livro = new LivrariaOnline();
		
		while (continuar) 
		{
			op = Integer.parseInt(JOptionPane.showInputDialog(null, 
					  "0- Finalizar.\n"
					+ "1- Adicionar Palavra.\n"
					+ "2- Remover Palavras.\n"
					+ "3- Mostrar Dicionário.\n"
					+ "4- Verificar qual a palavra mais frequente.\n"
					+ "Digite a opção desejada: ",
					"MENU", JOptionPane.QUESTION_MESSAGE));
			
			switch (op) 
			{
				case 0:
					JOptionPane.showMessageDialog(null,"Obrigado por testar meu algoritmo!");
					continuar = false;
					break;
				case 1:
					link = JOptionPane.showInputDialog(null,"Informe a link: ", 
							"ADICIONAR LIVRO: ", JOptionPane.INFORMATION_MESSAGE );
					titulo = JOptionPane.showInputDialog(null,"Informe agora o título: ", 
							"ADICIONAR LIVRO: ", JOptionPane.INFORMATION_MESSAGE );
					autor = JOptionPane.showInputDialog(null,"Informe e agora o autor: ", 
							"ADICIONAR LIVRO: ", JOptionPane.INFORMATION_MESSAGE );
					preco = Double.parseDouble(JOptionPane.showInputDialog(null,"E qual o preço de venda: ", 
							"ADICIONAR LIVRO: ", JOptionPane.INFORMATION_MESSAGE ));
					livro.adicionarPalavra(link, titulo, autor, preco);
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				default:
					JOptionPane.showMessageDialog(null, "Digite uma opção conforme o menu apresentado",
							"OPÇÃO INVÁLIDA!", JOptionPane.ERROR_MESSAGE);
					break;
			}
		}
	}
}
