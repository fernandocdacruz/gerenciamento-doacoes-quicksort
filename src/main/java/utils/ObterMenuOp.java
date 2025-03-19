package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ObterMenuOp {
	
	public static int obterOp(Scanner scanner) {
		int op = 0;
		boolean inputValido = false;
		while (!inputValido) {
			try {
				mostrarMenu();
				System.out.print("\nDigite a opção desejada: ");
				op = scanner.nextInt();
				testarOp(op);
				inputValido = true;
			} catch (InputMismatchException e) {
				System.out.println("\nInput inválido. Tente novamente");
				scanner.next();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return op;
	}
	
	protected static void  mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[0] - Sair");
		sb.append("\n[1] - Realizar doação");
		sb.append("\n[2] - Ordenar doações por valor");
		sb.append("\n[3] - Ordenar doações por data");
		sb.append("\n[4] - Gerar relatórios");
		System.out.println(sb);
	}
	
	protected static void testarOp(int op) {
		if (op < 0 || op > 4) {
			throw new IllegalArgumentException("\nOpção inválida. Tente novamente.");
		}
	}
	
}
