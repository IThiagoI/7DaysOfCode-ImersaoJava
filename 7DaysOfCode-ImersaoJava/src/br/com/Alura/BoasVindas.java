package br.com.Alura;

public abstract class BoasVindas {

	public static String getBoasVindas() {
		String boasVindas = """
				Olá, tudo bem?
				Bem vindo ao gerador de figurinhas!!
				me diga o número correspondente ao tema que você deseja gerar as figurinhas?
				
				1 - Top 10 filmes;
				2 - fotos tiradas pela Nasa;
				3 - Animes; 
				""";
		return boasVindas;
	}
	public static String getNovaSolicitacao() {
		String novaSolicitacao = """
				Me diga o número correspondente ao tema que você deseja gerar as figurinhas?
				
				1 - Top 10 filmes;
				2 - fotos tiradas pela Nasa;
				3 - Animes; 
				""";
		return novaSolicitacao;
	}
}
