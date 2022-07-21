package br.com.Alura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    
    public List<Map<String, String>> parse(String json, Pattern patternItens, Pattern patternAtributos) {

        Matcher matcher = patternItens.matcher(json);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Não encontrou items.");
        }

        String[] itens = matcher.group(1).split("\\},\\{");
        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : itens) {

            Map<String, String> atributosItem = new HashMap<>();

            Matcher matcherAtributosJson = patternAtributos.matcher(item);
            while (matcherAtributosJson.find()) {
                String atributo = matcherAtributosJson.group(1);
                String valor = matcherAtributosJson.group(2);
                atributosItem.put(atributo, valor);
            }

            dados.add(atributosItem);
        }

        return dados;
    }
}