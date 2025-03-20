package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ObterDouble {

	public static double obter(String prompt, Scanner scanner) {
		double valor = 0;
		boolean inputValido = false;
		while (!inputValido) {
			try {
				System.out.print(prompt);
				valor = scanner.nextDouble();
				testarDouble(valor);
				inputValido = true;
			} catch (InputMismatchException e) {
				System.out.println("\nInput inválido. Tentar novamente.");
				scanner.next();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return valor;
	}
	
	public static void testarDouble(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("\nValor de doação inválido. Tente novamente.");
		}
	}
	
}
