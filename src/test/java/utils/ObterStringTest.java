package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ObterStringTest {
	
	@Test
    public void testarString_entradaValida() {
        assertFalse(ObterString.testarString("teste"));
    }

    @Test
    public void testarString_entradaInvalida() {
        assertTrue(ObterString.testarString(""));
        assertTrue(ObterString.testarString("   "));
        assertTrue(ObterString.testarString("\t"));
    }

    @Test
    public void obter_entradaValida() {
        String input = "teste";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        String result = ObterString.obter("Digite algo: ", scanner);
        assertEquals("teste", result);
    }

    @Test
    public void obter_entradaInvalida() {
        String input = "\nTeste";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        String result = ObterString.obter("Digite algo: ", scanner);
        assertEquals("Teste", result);
    }

    @Test
    public void obter_multiplasEntradasInvalidas() {
        String input = "\n \n\t\nTeste";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        String result = ObterString.obter("Digite algo: ", scanner);
        assertEquals("Teste", result);
    }

    @Test
    public void obter_promptCorreto() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "teste";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        ObterString.obter("Digite algo: ", scanner);
        String output = outContent.toString();
        assertTrue(output.contains("Digite algo: "));
    }
	
}
