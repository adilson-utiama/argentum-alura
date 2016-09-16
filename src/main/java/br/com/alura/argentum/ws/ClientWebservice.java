package br.com.alura.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.alura.argentum.modelo.Negociacao;
import br.com.alura.argentum.reader.LeitorXML;

public class ClientWebservice {
	
	public static final String URL_WS = "http://argentumws.caelum.com.br/negociacoes"; 

	public List<Negociacao> getNegociacoes() {

		HttpURLConnection connection = null;
		
		try {
			URL url = new URL(URL_WS);
			connection = (HttpURLConnection) url.openConnection();

			InputStream inputStream = connection.getInputStream();

			return new LeitorXML().carregaLista(inputStream);

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			connection.disconnect();
		}

	}
	
	
	public static void main(String[] args) {
		
		ClientWebservice ws = new ClientWebservice();
		List<Negociacao> negociacoes = ws.getNegociacoes();
		for (Negociacao negociacao : negociacoes) {
			System.out.println(negociacao.getPreco());
		}
	}
}
