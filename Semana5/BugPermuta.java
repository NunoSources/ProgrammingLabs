import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Nuno Fontes, n 46413
 *
 */

/**
 * Pede um vector ao utilizador e imprime uma permutacao aleatoria do mesmo 
 */

public class BugPermuta {

	public static void main(String[] args) throws FileNotFoundException{
		// Pede ao utilizador os numeros
		Scanner sc = new Scanner(System.in);
		System.out.println("Escreva uma sequencia de numeros separados por espacos:");
		String lido = sc.nextLine();
		sc.close();

		// Cria um vector com os numeros
		try{
			String[] numeros = lido.split("");

			int[] nums = new int[numeros.length];
			for(int i = 0 ; i < numeros.length; i++) {
				nums[i] = Integer.parseInt(numeros[i]);
			}

			// Faz a permuta
			permutar(new int[nums.length]);

			// Imprime o resultado
			for(int i = 0 ; i < nums.length ; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
		}
		catch(NumberFormatException e){
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Faz permutacoes aleatorias num vector
	 * @param vector O vector que vai ser permutado
	 */
	public static void permutar(int[] vector) {
		Random rnd = new Random();
		for (int i = vector.length ; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Troca o indice index com o indice i
			int a = vector[i];
			vector[index] = vector[i];
			vector[i] = a;
		}
	}

}
