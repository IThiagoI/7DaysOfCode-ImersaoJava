package br.com.Alura;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class GetHttpClient {

	public String GetHttp(String url) {
		
		try {
			HttpRequest request;
			request = HttpRequest
					.newBuilder()
					.uri(new URI(url))
					.GET()
					.build();
		
			HttpClient cliente = HttpClient.newBuilder().build();
			HttpResponse<String> resposta = cliente.send(request, BodyHandlers.ofString());
			String jsonFilmes = resposta.body();
			return jsonFilmes;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Não consegui pegar os dados da API!");
			
		}
	}
}
