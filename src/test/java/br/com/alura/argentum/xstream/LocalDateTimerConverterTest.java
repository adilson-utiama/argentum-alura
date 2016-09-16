package br.com.alura.argentum.xstream;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.modelo.Negociacao;

public class LocalDateTimerConverterTest {

	@Test
	public void deveRetornarUmXmlComDataCorreta() {
		
		LocalDateTime data = LocalDateTime.of(2016, 9, 15, 10, 00);
		Negociacao negociacao = new Negociacao(40.0, 10, data );
		
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		String xmlConvertido = stream.toXML(negociacao);
		
		String xmlEsperado = 
				  "<negociacao>\n"
				+  "  <preco>40.0</preco>\n"
				+  "  <quantidade>10</quantidade>\n"
				+  "  <data>\n"
				+  "    <time>1473944400000</time>\n"
				+  "    <timezone>America/Sao_Paulo</timezone>\n"
				+  "  </data>\n"
				+ "</negociacao>";
		
		Assert.assertEquals(xmlEsperado, xmlConvertido);
	}
	
	@Test
	public void deveConverterUmXmlParaUmaNegociacaoCorreta(){
		String xml = 
				  "<negociacao>\n"
				+  "  <preco>40.0</preco>\n"
				+  "  <quantidade>10</quantidade>\n"
				+  "  <data>\n"
				+  "    <time>1473944400000</time>\n"
				+  "    <timezone>America/Sao_Paulo</timezone>\n"
				+  "  </data>\n"
				+ "</negociacao>";
		
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		
		Negociacao negociacaoGerada = (Negociacao) stream.fromXML(xml);
		
		LocalDateTime data = LocalDateTime.of(2016, 9, 15, 10, 00);
		Negociacao negociacaoEsperada = new Negociacao(40.0, 10, data );
		
		Assert.assertEquals(negociacaoEsperada, negociacaoGerada);
	}

}
