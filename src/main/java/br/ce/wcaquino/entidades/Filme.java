package br.ce.wcaquino.entidades;

public class Filme {
	
	private int estoque = 0;
	private double aluguel = 0;

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getAluguel() {
		return aluguel;
	}

	public void setAluguel(double aluguel) {
		this.aluguel = aluguel;
	}
}