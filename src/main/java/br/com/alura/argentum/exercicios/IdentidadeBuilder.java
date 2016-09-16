package br.com.alura.argentum.exercicios;

public class IdentidadeBuilder {

	private int numero;
    private String nome;
    private String nomeDaMae;
    private String nomeDoPai;
    private String estadoOndeNasceu;
    
    public IdentidadeBuilder comNumero(int numero){
    	this.numero = numero;
    	return this;
    }
    
    public IdentidadeBuilder comNome(String nome){
    	this.nome = nome;
    	return this;
    }
    
    public IdentidadeBuilder comNomeDaMae(String nomeDaMae){
    	this.nomeDaMae = nomeDaMae;
    	return this;
    }
    
    public IdentidadeBuilder comNomeDoPai(String nomeDoPai){
    	this.nomeDoPai = nomeDoPai;
    	return this;
    }
    
    public IdentidadeBuilder comEstadoOndeNasceu(String estadoOndeNasceu){
    	this.estadoOndeNasceu = estadoOndeNasceu;
    	return this;
    }
    
    public Identidade geraIdentidade(){
    	return new Identidade(numero, nome, nomeDaMae, nomeDoPai, estadoOndeNasceu);
    }
}
