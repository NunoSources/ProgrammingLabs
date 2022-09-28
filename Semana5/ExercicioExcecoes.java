
/**
 * @author Nuno Fontes, n 46413
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExercicioExcecoes {

	/**
	 * Le vector de inteiros e uma potencia e imprime os valores das 
	 * potencias dos inteiros
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(args[0]));
		int tamanho  = lerTamanhoVector(sc);
		int[] inteiros  = leInteirosVector(sc,tamanho);
		double potencia = lerValorPotencia(sc);
		double[] raizes = calculaPotencias(inteiros, potencia);
		imprimeVector(raizes);

		if(potencia < 0){
			throw new IllegalArgumentException();
		}

		try{
			lerTamanhoVector(sc);
		}
		catch(InputMismatchException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Ocorreu uma excecao porque a String lida "
					+ "nao pode ser convertida para um inteiro.");
			e.printStackTrace();
		}

		try{
			leInteirosVector(sc, tamanho);
		}
		catch(InputMismatchException e){
			System.out.println(e.getMessage());
		}

		try{
			calculaPotencias(inteiros, potencia);
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}

		try{
			double n = sc.nextInt();
			System.out.println(n);
			throw new FileNotFoundException();
		}
		catch(FileNotFoundException e){
			System.out.println("Ocorreu uma excecao porque "
					+ "o ficheiro nao existe");
		}
	}

	/**
	 * Le o tamanho do vector original
	 * @param sc - o scanner usado para a leitura
	 * @return o tamanho do vector a ler
	 * @requires sc != null
	 */
	public static int lerTamanhoVector(Scanner sc){
		if(sc.nextInt() <= 0){
			throw new InputMismatchException("Primeira linha do ficheiro"
					+ " tem de corresponder a um inteiro positivo.");
		}
		return Integer.parseInt(sc.nextLine());
	}

	/**
	 * Le para um vector de inteiros os seus valores
	 * @param sc - o scanner usado para a leitura
	 * @param tamanho - o valor que eh suposto o vector ter
	 * @return o vector de inteiros obtidos da leitura
	 * @requires tamanho > 0
	 */
	public static int[] leInteirosVector(Scanner sc, int tamanho) {
		if(tamanho != sc.nextInt(2)){
			throw new InputMismatchException("Tamanho tem de ser igual ao "
					+ "ao numero de inteiros na segunda linha.");
		}
		return null;
	} 

	/**
	 * Leitura do valor de potencia
	 * @param sc o scanner de onde obter os valores
	 * @return a potencia
	 * @requires sc != null
	 */
	public static double lerValorPotencia(Scanner sc) {
		return Double.parseDouble(sc.nextLine());
	}

	/**
	 * Determina as potencias dos elementos de um vector
	 * @param inteiros - o vector original
	 * @param potencia - a potencia que se pretende calcular do vector de inteiros
	 * @return o vector com o calculo das potencias de inteiros
	 * @requires potencia >= 0, inteiros != null
	 */
	private static double[] calculaPotencias(int[] inteiros, double potencia) {
		/*for(int i = 0; i < inteiros.length; i++){
			potencia = ;
		}
		if(potencia = NaN ???){
			throw new ArithmeticException();
		}*/
		return null;
	}

	/**
	 * Imprime os valores de um vectos de doubles
	 * @param raizes - o vector do qual se quer imprimir os valores
	 * @requires raizes != null
	 */
	private static void imprimeVector(double[] raizes) {
		for (double d : raizes) {
			System.out.print(d + " ");
		}
		System.out.println();
	}

}
