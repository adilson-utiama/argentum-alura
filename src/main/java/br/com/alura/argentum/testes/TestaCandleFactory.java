package br.com.alura.argentum.testes;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import br.com.alura.argentum.modelo.Candle;
import br.com.alura.argentum.modelo.CandleFactory;
import br.com.alura.argentum.modelo.Negociacao;

public class TestaCandleFactory {
	
	public static void main(String[] args) {
		
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao ne01 = new Negociacao(40.0, 100, hoje);
		Negociacao ne02 = new Negociacao(35.0, 100, hoje);
		Negociacao ne03 = new Negociacao(45.0, 100, hoje);
		Negociacao ne04 = new Negociacao(20.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(ne01, ne02, ne03, ne04);
		
		CandleFactory fabrica = new  CandleFactory();
		
		Candle candlestick = fabrica.geraCandleParaData(negociacoes, hoje);
		
		System.out.println(candlestick.getAbertura());
		System.out.println(candlestick.getFechamento());
		System.out.println(candlestick.getMaximo());
		System.out.println(candlestick.getMinimo());
		System.out.println(candlestick.getVolume());
		System.out.println(candlestick.getData());
	}

	
	
	
}
