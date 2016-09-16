package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeSerie {

	public static SerieTemporal criaSerie(double... valores){
		
		List<Candle> candles = new ArrayList<>();
		for (double n : valores) {
			candles.add(new Candle(n, n, n, n, n, LocalDateTime.now()));
		}
		
		return new SerieTemporal(candles);
	}
}
