package br.com.Alura;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ExtratorDeConteudoDeAnimes implements ExtratorDeConteudo {

	@Override
	public List<Conteudo> extraiConteudos(String json) {
		
		Pattern patternItens = Pattern.compile(".*\\[(.+)\\].*");
	    Pattern patternAtributos = Pattern.compile(",\"(.+?)\":\"(.*?)\"");
		List<Map<String, String>> listaDeAtributos = new JsonParser().parse(json, patternItens, patternAtributos);
		ArrayList<Conteudo> conteudos = new ArrayList<>();
		for (Map<String, String> atributos : listaDeAtributos) {
			
			String titulo = atributos.get("anime_name");
			String imagem =  atributos.get("anime_img");
			Conteudo conteudo = new Conteudo(titulo, imagem);
			conteudos.add(conteudo);
		}
		return conteudos;	
	}
}
