package br.com.alura.argentum.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
public class OlaMundoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private String mensagem = "Esta mensagem veio do bean";
	private String nome;
	
	private LineChartModel modeloGrafico;
	int[] horasDeEstudo = {3,2,1,5,4,3,2};
	
	public OlaMundoBean(){
		this.modeloGrafico = new LineChartModel();
		
		this.modeloGrafico.setLegendPosition("w");
		LineChartSeries linha = new LineChartSeries();
		linha.setLabel("Horas Estudadas");
		for (int i = 0; i < horasDeEstudo.length; i++) {
			linha.set(i + 1, horasDeEstudo[i]);
		}
		this.modeloGrafico.addSeries(linha);
		
	}
	
	
	public LineChartModel getModeloGrafico() {
		return modeloGrafico;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void botaoClicado(){
		System.out.println("Botao clicado, seu nome é: " + this.nome);
	}
}
