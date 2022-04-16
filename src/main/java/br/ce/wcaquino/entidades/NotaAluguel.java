package br.ce.wcaquino.entidades;

import java.util.Date;

public class NotaAluguel {
	private double preco;
	private Date dataEntrega;
	private int pontuacao;

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date time) {
		dataEntrega = time;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
}