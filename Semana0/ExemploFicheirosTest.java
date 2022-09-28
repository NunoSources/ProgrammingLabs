import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class ExemploFicheirosTest {



	@Test
	public void testCopiaTexto () throws IOException {

		String esperado = "abcdefghijklmnopqrstuvwxyz" + "\n";

		String texto = "abcdefghijklmnopqrstuvwxyz";

		PrintWriter in = new PrintWriter("input.txt");
		in.write(texto);
		in.close();

		ExemploFicheiros.copiaTexto("input.txt", "output.txt");
		String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), StandardCharsets.UTF_8);


		assertEquals(esperado, obtida);
	}

	@Test
	public void testTudoMinusculas () throws IOException {
		String esperado = "abcdefghijklmnopqrstuvwxyz" + "\n";

		String texto = "ABcdefghijklmnopqrstuvWXYZ";

		PrintWriter in = new PrintWriter("input.txt");
		in.write(texto);
		in.close();


		ExemploFicheiros.tudoMinusculas("input.txt", "output.txt");
		String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), StandardCharsets.UTF_8);

		assertEquals(esperado, obtida);
	}

	@Test
	public void testGuardaPares () throws IOException {
		String esperado = 	"12" + "\n" +
				"30" + "\n";

		String texto = "12" + "\n" + "15" + "\n" + "30";

		PrintWriter in = new PrintWriter("input.txt");
		in.write(texto);
		in.close();


		ExemploFicheiros.guardaPares("input.txt", "output.txt");
		String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), StandardCharsets.UTF_8);

		assertEquals(esperado, obtida);
	}

	@Test
	public void testCalculaDobro () throws IOException {
		String esperado = 	"24" + "\n" +
				"30" + "\n";

		String texto = "12"+ "\n" + "15";
		PrintWriter in = new PrintWriter("input.txt");
		in.write(texto);
		in.close();



		ExemploFicheiros.calculaDobro("input.txt", "output.txt");
		String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), StandardCharsets.UTF_8);

		assertEquals(esperado, obtida);	
	}

	@Test
	public void testPotenciasDe10 () throws IOException {

		String esperado = 	"1" + "\n" +
				"2" + "\n" +
				"0" + "\n" +
				"1" + "\n";

		String texto = "1"+ "\n" + "10" + "\n" + "10" + "\n" + "1000";
		PrintWriter in = new PrintWriter("input.txt");
		in.write(texto);
		in.close();



		ExemploFicheiros.potenciasDe10("input.txt", "output.txt",3);
		String obtida = new String(Files.readAllBytes(Paths.get("output.txt")), StandardCharsets.UTF_8);
		assertEquals(esperado, obtida);	
	}
}
