package br.com.alura.argentum.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

//Classe imutavel
public final class Negociacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final double preco;
	private final int quantidade;
	private final LocalDateTime data;
	
	public Negociacao(double preco, int quantidade, LocalDateTime data) {
		if(quantidade < 0 || quantidade == 0){
			throw new IllegalArgumentException("A quantidade deve ser um valor positivo");
		}
		if(preco < 0){
			throw new IllegalArgumentException("O preco nao pode ser negativo.");
		}
		if(data == null){
			throw new IllegalArgumentException("A data nao pode ser nulo");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public LocalDateTime getData() {
		return data;
	}

	public double getVolume() {
		return this.preco * this.quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantidade;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Negociacao other = (Negociacao) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

	public boolean isMesmoDia(LocalDateTime outraData) {
		return this.data.getDayOfMonth() == outraData.getDayOfMonth() &&
				this.data.getMonth() == outraData.getMonth() &&
				this.data.getYear() == outraData.getYear();
	}
	
	

}
