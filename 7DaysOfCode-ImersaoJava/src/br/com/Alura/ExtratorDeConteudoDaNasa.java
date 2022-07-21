package br.com.Alura;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

	public List<Conteudo> extraiConteudos (String json) {
		
		Pattern patternItens = Pattern.compile(".*\\[(.+)\\].*");
	    Pattern patternAtributos = Pattern.compile("\"(.+?)\":\"(.*?)\"");
		List<Map<String, String>> listaDeAtributos = new JsonParser().parse(json, patternItens, patternAtributos);
		
		ArrayList<Conteudo> conteudos = new ArrayList<>();
		
		for (Map<String, String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String imagem =  atributos.get("url");
			
			Conteudo conteudo = new Conteudo(titulo, imagem);
			conteudos.add(conteudo);
		}
		return conteudos;	
	}
	
}
