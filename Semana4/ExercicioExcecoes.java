
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Nuno Fontes n46413
 *
 */
public class ExercicioExcecoes {

	public static final int ZERO = 0;

	/**
	 * Le vector de inteiros e uma potencia e imprime os valores das 
	 * potencias dos inteiros
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		try(Scanner sc = new Scanner(new File(args[0]))){
			int tamanho  = lerTamanhoVector(sc);
			int[] inteiros  = leInteirosVector(sc,tamanho);
			double potencia = lerValorPotencia(sc);
			double[] raizes = calculaPotencias(inteiros, potencia);
			imprimeVector(raizes);

		} catch(NumberFormatException e){
			System.out.println("Nao consegue converter num Integer");
		} catch(InputMismatchException e){
			System.out.println("O valor nao corresponde ao esperado");
		} catch(IllegalArgumentException e){
			System.out.println("O valor da potencia eh negativo");
		} catch(ArithmeticException e){
			System.out.println("O resultado esperado nao corresponde a um numero");
		} catch(FileNotFoundException e){
			System.out.println("O ficheiro nao existe!");
		}
	}




	/**
	 * Le o tamanho do vector original
	 * @param sc - o scanner usado para a leitura
	 * @return o tamanho do vector a ler
	 * @requires sc != null
	 */
	public static int lerTamanhoVector(Scanner sc) {
		int primLinha = sc.nextInt();
		if(primLinha <= ZERO){
			throw new InputMismatchException("A primeira linha do ficheiro nao "
					+ "eh um inteiro positivo");
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
		int segLinha = sc.nextInt();
		int[] resultado = new int[tamanho];
		if(tamanho != segLinha){
			throw new InputMismatchException("O tamanho nao eh igual ao "
					+ "numero inteiros na segunda linha");
		}
		return resultado;
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
		double[] resultado = new double[inteiros.length];
		for(int i = 0; i < resultado.length; i++){
			resultado[i] = Math.pow(i, potencia);
			if(resultado[i] == Double.longBitsToDouble(0x7ff8000000000000L)){
				throw new ArithmeticException("O resultado esperado nao corresponde "
						+ "a um numero");
			}
		}
		return resultado;
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
