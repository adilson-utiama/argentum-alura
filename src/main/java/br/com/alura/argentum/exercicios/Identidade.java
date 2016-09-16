package br.com.alura.argentum.exercicios;

public class Identidade {

	private int numero;
    private String nome;
    private String nomeDaMae;
    private String nomeDoPai;
    private String estadoOndeNasceu;

    public Identidade(int numero, String nome, String nomeDaMae, String nomeDoPai, String estadoOndeNasceu){
        this.numero = numero;
        this.nome = nome;
        this.nomeDaMae = nomeDaMae;
        this.nomeDoPai = nomeDoPai;
        this.estadoOndeNasceu = estadoOndeNasceu;
    }

	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public String getNomeDoPai() {
		return nomeDoPai;
	}

	public String getEstadoOndeNasceu() {
		return estadoOndeNasceu;
	}
    
    

}
