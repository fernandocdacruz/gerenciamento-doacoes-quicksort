package service;

import java.util.Scanner;

public class ExecutarOp {

	public static void executar(Scanner scanner, int op) {
		switch (op) {
		case 1: GerenciadorDoacoes.adicionarDoacoes(scanner);
			break;
		}
	}
	
}
