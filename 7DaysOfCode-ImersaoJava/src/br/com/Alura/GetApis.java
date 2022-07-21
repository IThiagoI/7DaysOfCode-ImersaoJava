package br.com.Alura;

import java.util.List;

public abstract class GetApis {

	public static List<Conteudo> getImdb() {
		String url = "https://alura-imdb-api.herokuapp.com/movies";
		ExtratorDeConteudo conteudos = new ExtratorDeConteudoDoIMDB();
		String json = new GetHttpClient().GetHttp(url);
		List<Conteudo> conteudo = conteudos.extraiConteudos(json);
		return conteudo;
		
	}
	public static List<Conteudo> getNasa() {
		String url = "https://api.nasa.gov/planetary/apod?api_key=vKIpu5frnRtXLde7KcyDicLijWJ9udTXTPehaleP&start_date=2022-07-01&end_date=2022-07-20";
		ExtratorDeConteudo conteudos = new ExtratorDeConteudoDaNasa();
		String json = new GetHttpClient().GetHttp(url);
		List<Conteudo> conteudo = conteudos.extraiConteudos(json);
		return conteudo;

	}
	public static List<Conteudo> getAnimes() {
		String url = "https://anime-facts-rest-api.herokuapp.com/api/v1";
		ExtratorDeConteudo conteudos = new ExtratorDeConteudoDeAnimes();
		String json = new GetHttpClient().GetHttp(url);
		List<Conteudo> conteudo = conteudos.extraiConteudos(json);
		return conteudo;

	}
}
	
