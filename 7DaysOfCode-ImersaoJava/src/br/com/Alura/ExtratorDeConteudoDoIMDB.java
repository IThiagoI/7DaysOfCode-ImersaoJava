package br.com.Alura;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo{

	public List<Conteudo> extraiConteudos(String json) {
		
		Pattern patternItens = Pattern.compile(".*\\[(.+)\\].*");
	    Pattern patternAtributos = Pattern.compile("\"(.+?)\":\"(.*?)\"");
		List<Map<String, String>> listaDeAtributos = new JsonParser().parse(json, patternItens, patternAtributos);
		
		ArrayList<Conteudo> conteudos = new ArrayList<>();
		
		for (Map<String, String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String imagem =  atributos.get("image");
			String imagemMaior = "";
			Pattern pattern = Pattern.compile(".*\\@(.*)\\.");
			Matcher matcher = pattern.matcher(imagem);
			while(matcher.find()) {
				imagemMaior = imagem.replaceAll(matcher.group(1), "");
			}
			
			Conteudo conteudo = new Conteudo(titulo, imagemMaior);
			conteudos.add(conteudo);
		}

		return conteudos;
	}
}
