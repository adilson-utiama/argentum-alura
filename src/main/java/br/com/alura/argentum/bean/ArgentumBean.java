package br.com.alura.argentum.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.LineChartModel;

import br.com.alura.argentum.graficos.GeradorDeModeloGrafico;
import br.com.alura.argentum.indicadores.IndicadorFactory;
import br.com.alura.argentum.modelo.Candle;
import br.com.alura.argentum.modelo.CandleFactory;
import br.com.alura.argentum.modelo.Negociacao;
import br.com.alura.argentum.modelo.SerieTemporal;
import br.com.alura.argentum.ws.ClientWebservice;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Negociacao> negociacoes;
	private LineChartModel modeloGrafico;
	
	private String nomeMedia;
	private String nomeIndicadorBase;

	public ArgentumBean() {
		this.negociacoes = new ClientWebservice().getNegociacoes();
		geraGrafico();
		
	}

	public void geraGrafico() {
		System.out.println("PLOTANDO: " + nomeMedia + " de " + nomeIndicadorBase );
		List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		
		GeradorDeModeloGrafico grafico = new GeradorDeModeloGrafico(serie, 2, serie.getUltimaPosicao());
		
		grafico.plotaIndicador(new IndicadorFactory(nomeMedia, nomeIndicadorBase).defineIndicador());
	
		this.modeloGrafico = grafico.getModeloGrafico();
	}
	
	

	public LineChartModel getModeloGrafico() {
		return modeloGrafico;
	}

	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}

	public String getNomeMedia() {
		return nomeMedia;
	}

	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}

	public String getNomeIndicadorBase() {
		return nomeIndicadorBase;
	}

	public void setNomeIndicadorBase(String nomeIndicadorBase) {
		this.nomeIndicadorBase = nomeIndicadorBase;
	}
}
