package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CandleFactoryTest {

	@Test
	public void sequenciaSimplesDeNegociacoes() {
		LocalDateTime hoje = LocalDateTime.now();

		Negociacao ne01 = new Negociacao(40.0, 100, hoje);
		Negociacao ne02 = new Negociacao(35.0, 100, hoje);
		Negociacao ne03 = new Negociacao(45.0, 100, hoje);
		Negociacao ne04 = new Negociacao(20.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(ne01, ne02, ne03, ne04);

		CandleFactory fabrica = new CandleFactory();

		Candle candlestick = fabrica.geraCandleParaData(negociacoes, hoje);
		
		Assert.assertEquals(20.0, candlestick.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candlestick.getMaximo(), 0.00001);
		Assert.assertEquals(40.0, candlestick.getAbertura(), 0.00001);
		Assert.assertEquals(20.0, candlestick.getFechamento(), 0.00001);
		Assert.assertEquals(14000.0, candlestick.getVolume(), 0.00001);
	}
	
	@Test
	public void geraCandlestickComUmaNegociacao(){
		LocalDateTime data = LocalDateTime.now();
		
		Negociacao negociacao = new Negociacao(40.0, 100, data);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao);
		
		CandleFactory fabrica = new CandleFactory();
		
		Candle candle = fabrica.geraCandleParaData(negociacoes, data);
		
		Assert.assertEquals(40.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(40.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(4000.0, candle.getVolume(), 0.00001);
		
		
	}
	
	@Test
	public void geraCandlestickComZerosNoCasoDeNenhumaNegociacao(){
		LocalDateTime data = LocalDateTime.now();
		
		List<Negociacao> negociacoes = new ArrayList<>();
		CandleFactory fabrica = new CandleFactory();
		Candle candle = fabrica.geraCandleParaData(negociacoes, data);
		
		Assert.assertEquals(0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(0, candle.getVolume(), 0.00001);
	}
	
	@Test
	public void negociacaoDeTresDiasDiferentesGeraTresCandlesticks(){
		LocalDateTime hoje = LocalDateTime.now();
		Negociacao neg01 = new Negociacao(50.0, 20, hoje);
		Negociacao neg02 = new Negociacao(100.0, 20, hoje);
		Negociacao neg03 = new Negociacao(150.0, 20, hoje);
		
		LocalDateTime amanha = hoje.plusDays(1);
		Negociacao neg04 = new Negociacao(50.0, 100, amanha);
		Negociacao neg05 = new Negociacao(10.0, 20, amanha);
		
		LocalDateTime depois = hoje.plusDays(2);
		Negociacao neg06 = new Negociacao(35.0, 20, depois);
		Negociacao neg07 = new Negociacao(35.0, 20, depois);
		
		List<Negociacao> negociacoes = Arrays.asList(neg01,neg02,neg03,neg04,neg05,neg06,neg07);
		
		CandleFactory fabrica = new CandleFactory();
		
		List<Candle> candlesticks = fabrica.constroiCandles(negociacoes);
		
		Assert.assertEquals(3, candlesticks.size());
		Assert.assertTrue(negociacoes.get(0).isMesmoDia(candlesticks.get(0).getData()));
		Assert.assertTrue(negociacoes.get(3).isMesmoDia(candlesticks.get(1).getData()));
		Assert.assertTrue(negociacoes.get(5).isMesmoDia(candlesticks.get(2).getData()));
		
		Assert.assertEquals(6000.0, candlesticks.get(0).getVolume(), 0.0000001);
		Assert.assertEquals(50.0, candlesticks.get(0).getMinimo(), 0.0000001);
		Assert.assertEquals(150.0, candlesticks.get(0).getMaximo(), 0.0000001);
		Assert.assertEquals(50.0, candlesticks.get(0).getAbertura(), 0.0000001);
		Assert.assertEquals(150.0, candlesticks.get(0).getFechamento(), 0.0000001);
		
	}

}
