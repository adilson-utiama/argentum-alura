package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

public class NegociacaoTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComPrecoNegativo() {
		new Negociacao(-20.0, 2, LocalDateTime.now());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComQuantidadeNegativaOuZero() {
		new Negociacao(10.0, -1, LocalDateTime.now());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComDataNula() {
		new Negociacao(10.0, 3, null);
	}

	@Test
	public void mesmoSegundoEhDoMesmoDia() {

		LocalDateTime agora = LocalDateTime.now();
		LocalDateTime mesmoMomento = agora;

		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
	    LocalDateTime manha =  LocalDateTime.of(2016, 02, 25, 8, 30);
	    LocalDateTime tarde =  LocalDateTime.of(2016, 02, 25, 15, 30);

	    Negociacao negociacao = new Negociacao(40.0, 100, manha);
	    Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void mesesDiferentesNaoEhNoMesmoDia() {
	    LocalDateTime manha =  LocalDateTime.of(2016, 02, 25, 8, 30);
	    LocalDateTime tarde =  LocalDateTime.of(2016, 03, 25, 15, 30);

	    Negociacao negociacao = new Negociacao(40.0, 100, manha);
	    Assert.assertFalse(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void anoDiferentesNaoEhNoMesmoDia() {
	    LocalDateTime manha =  LocalDateTime.of(2017, 02, 25, 8, 30);
	    LocalDateTime tarde =  LocalDateTime.of(2015, 02, 25, 8, 30);

	    Negociacao negociacao = new Negociacao(40.0, 100, manha);
	    Assert.assertFalse(negociacao.isMesmoDia(tarde));
	}

}
