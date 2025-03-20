package service;

import java.util.Scanner;

import model.Doacao;
import utils.ObterDouble;
import utils.ObterString;

public class GerenciadorDoacoes {

	private Doacao doacoes;
	
	public static void adicionarDoacoes(Scanner scanner) {
		//String doador;
		//Double valor;
		//LocalDate data;
		String doador = ObterString.obter("\nDigite o nome do doador: ", scanner);
		double obterValor = ObterDouble.obter("Digite o valor da doação: ", scanner, valor <= 0);
	}
	
}
