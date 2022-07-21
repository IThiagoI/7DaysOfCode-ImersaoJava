package br.com.Alura;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		/**
		 * Primeira parte é responsável por escolher qual o link da API que será consumida.
		 * 
		 * @author ThiagoCampos
		 */
		Scanner scan = new Scanner(System.in);
		int numeroEscolhido = 0;
		List<Conteudo> conteudo = new ArrayList<>();
		System.out.println(BoasVindas.getBoasVindas());
		numeroEscolhido = scan.nextInt();
		
		switch (numeroEscolhido) {
			default:
				while (numeroEscolhido < 1 || numeroEscolhido > 3) {
					System.out.println("""
						O número digitado não é válido, 
						por favor digite o número correspondente ao tema que deseja gerar as figurinhas
						
						1 - Top 10 filmes;
						2 - fotos tiradas pela Nasa;
						3 - Animes;
						""");	
				numeroEscolhido = scan.nextInt();
				}
			case 1:
				System.out.println("Solicitando a requisição ao site");
				conteudo = GetApis.getImdb();
				System.out.println("Solicitação realizada com sucesso!");
				break;
			case 2:
				System.out.println("Solicitando a requisição ao site");
				conteudo = GetApis.getNasa();
				System.out.println("Solicitação realizada com sucesso!");
				break;
			case 3:
				System.out.println("Solicitando a requisição ao site");
				conteudo = GetApis.getAnimes();
				System.out.println("Solicitação realizada com sucesso!");
				break;		
		}
		scan.close();
		/**
		 * Essa parte é responsável por gerar um arquivo HTML com as capas das imagens.
		 */
		System.out.println("Gerando o Arquivo.Html");
		try {
			PrintWriter writer = new PrintWriter("Arquivo.html");
			new HTMLGenerator(writer).generate(conteudo);
			writer.close();
			
		} catch (FileNotFoundException ex) {
			System.out.println("Não foi possível criar o Arquivo.html");
		}
		System.out.println("Arquivo.html Gerado com Sucesso!");
		
		/**
		 * Essa parte é responsável por pegar as imagens e transformar em figurinhas.
		 */
		System.out.println("Gerando Figurinhas");
		GeradorDeFigurinhas gerador = new GeradorDeFigurinhas();
		
		for (int i = 0; i <= 10 ; i++) {
			
			String titulo = conteudo.get(i).getTitulo() + ".png";			
			InputStream inputStream;
			try {
				inputStream = new URL(conteudo.get(i).getUrlImagem()).openStream();
				gerador.criaFiguras(inputStream, titulo);
				System.out.println("A figurinha " + conteudo.get(i).getTitulo() + " foi gerada com sucesso!");
			} catch (Exception e) {
				System.out.printf("Não foi possível pegar a URL da imagem %s \n", conteudo.get(i).getTitulo());
			}
		}
		System.out.println("Figurinhas Gerada");
		System.out.println("Muito Obrigado, e divirta-se!");
	}
}