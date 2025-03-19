package model;

import java.time.LocalDate;

public class Doacao {

	private String doador;
	private Double valor;
	private LocalDate data;
	
	public Doacao() {
	}

	public Doacao(String doador, Double valor, LocalDate data) {
		this.doador = doador;
		this.valor = valor;
		this.data = data;
	}

	public String getDoador() {
		return doador;
	}

	public void setDoador(String doador) {
		this.doador = doador;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Doacao [doador=" + doador + ", valor=" + valor + ", data=" + data + "]";
	}
	
}
