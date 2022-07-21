package br.com.Alura;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {
	
	private final PrintWriter writer;
	
	public HTMLGenerator(PrintWriter writer) {
		this.writer = writer;

	}

	public void generate(List<Conteudo> conteudo) {
		
		
		writer.println("""
			    <!DOCTYPE html>
				<html lang="pt-br">
					<head>
						<meta charset=\"utf-8\">
						<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
						<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
							+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
					</head>
					<body>
				""");
		String divTemplate = """
				<div class=\"card text-white bg-dark mb-3\" style="display:inline-block;max-width:18rem;min-width:18rem;">
					<h4 class=\"card-header\">%s</h4>
					<div class=\"card-body\">
						<img class=\"card-img\" src=\"%s\" alt=\"%s\">
						<p class=\"card-text mt-2\"></p>
					</div>
				</div>
				""";
		
		for (int i = 0; i < conteudo.size(); i++) {
			writer.println(String.format(divTemplate, conteudo.get(i).getTitulo(), conteudo.get(i).getUrlImagem(),conteudo.get(i).getTitulo()));
		}
		
		writer.println("""
					</body>
				</html>
				""");
	}
}
