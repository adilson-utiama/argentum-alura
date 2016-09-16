package br.com.alura.argentum.exercicios;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.alura.argentum.indicadores.IndicadorFechamento;

public class TestaReflection {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		Class<IndicadorFechamento> classe;
		
		try {
			classe =  (Class<IndicadorFechamento>) Class.forName("br.com.alura.argentum.indicadores.IndicadorFechamento");
			
			for (Field atributo : classe.getDeclaredFields()) {
				System.out.println(atributo);
			}
			
			for (Method metodo : classe.getDeclaredMethods()) {
				System.out.println(metodo);
			}
			
			IndicadorFechamento negociacao = classe.newInstance();
			System.out.println(negociacao);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
