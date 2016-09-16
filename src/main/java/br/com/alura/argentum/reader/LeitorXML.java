package br.com.alura.argentum.reader;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.modelo.Negociacao;
import br.com.alura.argentum.xstream.LocalDateTimeConverter;

public class LeitorXML {
	
	@SuppressWarnings("unchecked")
	public List<Negociacao> carregaLista(InputStream inputStream){
		
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		
		
		return (List<Negociacao>) stream.fromXML(inputStream);
	}

}
