package application;

import java.util.Locale;
import java.util.Scanner;

import service.ExecutarOp;
import utils.ObterMenuOp;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem vindo ao sistema de Doações 2025");
		int menuOp = 0;
		do {
			menuOp = ObterMenuOp.obterOp(scanner);
			ExecutarOp.executar(scanner, menuOp);
		} while (menuOp != 0);
		System.out.println("Sistema encerrado, agradecemos a doação!");
		scanner.close();
	}
	
}
