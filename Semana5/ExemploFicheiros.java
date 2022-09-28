
/**
 * @author Nuno Fontes, n 46413
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ExemploFicheiros {

	public static final int NUMMAX = 10;


	public static void copiaTexto (String fileIn, String fileOut) throws FileNotFoundException {
		Scanner in = new Scanner (new File(fileIn));
		PrintWriter out = new PrintWriter(fileOut);
		boolean novaLinha = in.hasNext();
		while (novaLinha){// enquanto o ficheiro nao terminar 
			out.println(in.nextLine());
			novaLinha = in.hasNext();
		}
		in.close();
		out.close();
	}


	/**
	 * faz a copia de um texto colocando tudo em minusculas
	 * @param in - de onde ler os valores
	 * @param out - o que escrever
	 * @requires in, out != null
	 */
	public static void tudoMinusculas (String fileIn, String fileOut) {
		// TODO Auto-generated method stub
	}

	/**
	 * regista os de in em out
	 * @param in
	 * @param out
	 * @requires in!=null && out != null e in so com numeros  
	 */
	public static void guardaPares (String filein, String fileout) throws FileNotFoundException {
		Scanner in = new Scanner (new File(filein));
		PrintWriter out = new PrintWriter(fileout);
		while (in.hasNextInt()){    // enquanto o ficheiro nao terminar
			int valorobtido = in.nextInt();
			calculadora aminhacalculadora = new calculadora();
			aminhacalculadora.Ehpar(valorobtido);
			if (aminhacalculadora.Ehpar(valorobtido)) {
				out.println(valorobtido);
			}
		}
		in.close();
		out.close();
	}

	/**
	 * regista o dobro de cada numero em in em out
	 * @param in
	 * @param out
	 * @requires in!=null && out != null e in so com numeros  
	 */
	public static void calculaDobro (String fileIn, String fileOut) throws FileNotFoundException {
		Scanner in = new Scanner (new File(fileIn));
		PrintWriter out = new PrintWriter(fileOut);
		boolean fim = true;
		while (!fim){
			calculadora aminhacalculadora = new calculadora();
			int valor = in.nextInt();
			System.out.println(aminhacalculadora.dobro(valor));
			//out.println(aminhacalculadora.dobro(valor));
		}
		in.close();
		out.close();
	}

	/**
	 * calculo no numero de vezes que aparecem 1, 10, ..., 10^n
	 * @param in - de onde ler os valores
	 * @param out - o que escrever
	 * @param n
	 * @requires in, out != null, in so com inteiros.
	 */
	public static void potenciasDe10 (String fileIn, String fileOut, int n) throws FileNotFoundException{
		Scanner in = new Scanner (new File(fileIn));
		PrintWriter out = new PrintWriter(fileOut);
		int[] potencias = new int[n+1];
		while(in.hasNextInt()){
			int valor = in.nextInt();
			calculadora.EhPotenciaDe10(potencias, valor);
		}

		//agora coloco os valor no ficheiro!
		for (int i = potencias.length; i < potencias.length; i++) {
			out.println(potencias[i]);
		}
		in.close();
		out.close();
	}

	/**
	 * Calcula o arredondamento dado um algarismo para a dezena mais proxima 
	 * @param algarismo - representacao de um algarismo em String
	 * @return 0 se 0 <= algarismo < 5 e 10 caso contrario
	 * @requires 0 <= algarismo < 10
	 */
	public static int metodo(String algarismo) {
		String str0 = "0";
		String str1 = "1";
		String str2 = "2";
		String str3 = "3";
		String str4 = "4";
		String str5 = "5";
		String str6 = "6";
		String str7 = "7";
		String str8 = "8";
		String str9 = "9";
		
		if(algarismo.equals(str2) || algarismo.equals(str3) || algarismo.equals(str4)
				|| algarismo.equals(str0) || algarismo.equals(str1)){
			return 0;
		}
		if(algarismo.equals(str5) || algarismo.equals(str6) || algarismo.equals(str7)){
			return NUMMAX;
		}
		if(algarismo.equals(str8) || algarismo.equals(str9)){
			return NUMMAX;
		}
		return 0;
	}


}