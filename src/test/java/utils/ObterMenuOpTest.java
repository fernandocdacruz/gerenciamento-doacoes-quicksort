package utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ObterMenuOpTest {

	@Test
	public void obterOp_entradaValida() {
		String input = "2";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		Scanner scanner = new Scanner(in);
		int op = ObterMenuOp.obterOp(scanner);
		assertEquals(2, op);
	}

	@Test
	public void obterOp_entradaInvalida_texto() {
		String input = "abc\n1";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		Scanner scanner = new Scanner(in);
		int op = ObterMenuOp.obterOp(scanner);
		assertEquals(1, op);
	}

	@Test
	public void obterOp_entradaInvalida_foraDoIntervalo() {
		String input = "5\n3";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		Scanner scanner = new Scanner(in);
		int op = ObterMenuOp.obterOp(scanner);
		assertEquals(3, op);
	}

	@Test
	public void mostrarMenu_exibeOpcoesCorretas() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ObterMenuOp.mostrarMenu();
		String output = outContent.toString();
		assertTrue(output.contains("[0] - Sair"));
		assertTrue(output.contains("[1] - Realizar doação"));
		assertTrue(output.contains("[2] - Ordenar doações por valor"));
		assertTrue(output.contains("[3] - Ordenar doações por data"));
		assertTrue(output.contains("[4] - Gerar relatórios"));
	}

	@Test
	public void testarOp_opcaoValida() {
		assertDoesNotThrow(() -> ObterMenuOp.testarOp(0));
		assertDoesNotThrow(() -> ObterMenuOp.testarOp(1));
		assertDoesNotThrow(() -> ObterMenuOp.testarOp(2));
		assertDoesNotThrow(() -> ObterMenuOp.testarOp(3));
		assertDoesNotThrow(() -> ObterMenuOp.testarOp(4));
	}

	@Test
	public void testarOp_opcaoInvalida_menorQueZero() {
		assertThrows(IllegalArgumentException.class, () -> ObterMenuOp.testarOp(-1));
		assertThrows(IllegalArgumentException.class, () -> ObterMenuOp.testarOp(-5));
	}

	@Test
	public void testarOp_opcaoInvalida_maiorQueQuatro() {
		assertThrows(IllegalArgumentException.class, () -> ObterMenuOp.testarOp(5));
		assertThrows(IllegalArgumentException.class, () -> ObterMenuOp.testarOp(10));
	}

}
