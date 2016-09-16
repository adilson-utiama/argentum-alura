package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;



public class CandleTest {

	@Test(expected=IllegalArgumentException.class)
	public void valorMaximoNaoDeveSerMenorQueVAlorMinimo() {
		Candle candle = new CandleBuilder()
				.comAbertura(40.0)
				.comFechamento(30.0)
				.comMaximo(15.0)
				.comMinimo(50.0)
				.comVolume(200.0)
				.comData(LocalDateTime.now())
				.gerarCandle();
	}
	
	@Test
	public void ehAltaSeFechamentoEhIgualAbertura(){
		Candle candle = new CandleBuilder()
				.comAbertura(30.0)
				.comFechamento(30.0)
				.comMaximo(50.0)
				.comMinimo(10.0)
				.comVolume(200.0)
				.comData(LocalDateTime.now())
				.gerarCandle();
		
		Assert.assertTrue(candle.isAlta());
	
	}

}
