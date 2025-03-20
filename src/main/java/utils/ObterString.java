package utils;

import java.util.Scanner;

public class ObterString {

	public static String obter(String prompt, Scanner scanner) {
		String str = null;
		boolean inputValido = false;
		boolean primeiraLeituraInput = true;
		while (!inputValido) {
			try {
				System.out.print(prompt);
				if (primeiraLeituraInput) {
					scanner.nextLine();
				}
				str = scanner.nextLine();
				boolean resultadoTeste = testarString(str);
				if (resultadoTeste) {
					primeiraLeituraInput = false;
					throw new IllegalArgumentException("\nEsse input não pode ficar em branco. Tente novamente.");
				}
				
				inputValido = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return str;
	}
	
	public static boolean testarString(String str) {
		boolean resultado = false;
		if (str.isBlank()) {
			resultado = true;
		}
		return resultado;
	}
	
}
