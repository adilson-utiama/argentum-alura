package br.com.alura.argentum.reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.argentum.modelo.Negociacao;


public class LeitorXMLTest {

	@Test
	public void carregaXmlComApenasUmaNegociacao() {
		String xml =
				"<list>\n"
				+  "  <negociacao>\n"
				+  "    <preco>40.0</preco>\n"
				+  "    <quantidade>10</quantidade>\n"
				+  "    <data>\n"
				+  "      <time>1473944400000</time>\n"
				+  "      <timezone>America/Sao_Paulo</timezone>\n"
				+  "    </data>\n"
				+ "  </negociacao>\n"
				+"</list>";
		
		LeitorXML leitorXML = new LeitorXML();
		InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
		List<Negociacao> negociacoes = leitorXML.carregaLista(inputStream);
		
		LocalDateTime data = LocalDateTime.of(2016, 9, 15, 10, 00);
		Negociacao negociacaoEsperada = new Negociacao(40.0, 10, data );
		
		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(negociacaoEsperada, negociacoes.get(0));
	}

}
