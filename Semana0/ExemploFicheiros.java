import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * @author Nuno Fontes 46413 
 *
 */
public class ExemploFicheiros {

	/**
	 * @param fileIn Ficheiro de texto de onde se vai ler​
	 * @param fileOut Ficheiro de texto onde se vai escrever​
	 * @throws FileNotFoundException
	 * @requires String fileIn != null && String fileOut != null
	 */
	public static void copiaTexto(String fileIn, String fileOut) throws FileNotFoundException{
		Scanner leitor = new Scanner(new File(fileIn));
		PrintWriter escritor = new PrintWriter(fileOut);

		while(leitor.hasNext()){
			escritor.println(leitor.nextLine());
		}

		leitor.close();
		escritor.close();
	}

	/**
	 * @param fileIn Ficheiro de texto de onde se vai ler​
	 * @param fileOut Ficheiro de texto onde se vai escrever
	 * @throws FileNotFoundException
	 * @requires String fileIn != null && String fileOut != null
	 */
	public static void tudoMinusculas(String fileIn, String fileOut) throws FileNotFoundException{
		Scanner leitor = new Scanner(new File(fileIn));
		PrintWriter escritor = new PrintWriter(fileOut);

		while(leitor.hasNext()){
			escritor.println(leitor.nextLine().toLowerCase());
		}

		leitor.close();
		escritor.close();
	}

	/**
	 * @param fileIn Ficheiro de texto de onde se vai ler​
	 * @param fileOut Ficheiro de texto onde se vai escrever
	 * @throws FileNotFoundException
	 * @requires String fileIn != null && String fileOut != null
	 */
	public static void guardaPares(String fileIn, String fileOut) throws FileNotFoundException{
		Scanner leitor = new Scanner(new File(fileIn));
		PrintWriter escritor = new PrintWriter(fileOut);

		while(leitor.hasNextInt()){
			int num = leitor.nextInt();
			if(num % 2 == 0)
				escritor.println(num);
		}

		leitor.close();
		escritor.close();
	}

	/**
	 * @param fileIn Ficheiro de texto de onde se vai ler​
	 * @param fileOut Ficheiro de texto onde se vai escrever
	 * @throws FileNotFoundException
	 * @requires String fileIn != null && String fileOut != null
	 */
	public static void calculaDobro(String fileIn, String fileOut) throws FileNotFoundException{
		Scanner leitor = new Scanner(new File(fileIn));
		PrintWriter escritor = new PrintWriter(fileOut);

		while(leitor.hasNextInt()){
			int num = leitor.nextInt();
			escritor.println(num*2);
		}

		leitor.close();
		escritor.close();
	}

	/**
	 * @param fileIn Ficheiro de texto de onde se vai ler​
	 * @param fileOut Ficheiro de texto onde se vai escrever
	 * @param n Valor inteiro
	 * @throws FileNotFoundException
	 * @requires String fileIn != null && String fileOut != null
	 */
	public static void potenciasDe10(String fileIn, String fileOut, int n) throws FileNotFoundException{
		Scanner leitor = new Scanner(new File(fileIn));
		PrintWriter escritor = new PrintWriter(fileOut);

		int[] contador = new int[n+1];

		while(leitor.hasNextInt()){
			int num = leitor.nextInt();
			for(int i = 0; i <= n; i++){
				if(num == Math.pow(10, i))
					contador[i] += 1;
			}
		}

		for(int i = 0; i < contador.length; i++){
			escritor.println(contador[i]);
		}

		leitor.close();
		escritor.close();
	}
}
