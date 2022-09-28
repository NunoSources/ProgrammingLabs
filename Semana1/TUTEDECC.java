import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * @author Nuno Fontes n 46413
 *
 */
public class TUTEDECC {


	/**
	 * 
	 * Metodo usado para efetuar a capitalizacao de Strings
	 * dependendo do valor do tipo e imprimir o resultado
	 * no ficheiro fileOut
	 * 
	 * @param fileIn ficheiro de leitura
	 * @param tipo inteiro para escolher o tipo de capitalizacao
	 * @param fileOut ficheiro de escrita
	 * @throws IOException
	 * @requires fileIn != null && fileOut != null && tipo >= -1 && tipo <= 1 
	 */
	public static void capitalizar (String fileIn, int tipo, String fileOut) throws IOException{

		Scanner leitor = new Scanner(new File(fileIn));
		PrintWriter escritor = new PrintWriter(fileOut);

		while(leitor.hasNextLine()){ //Enquanto o proximo token for uma String
			if(tipo == -1){ //Se o tipo for -1, imprime as Strings em minusculo
				escritor.println(leitor.nextLine().toLowerCase()); 
			}
			else if(tipo == 1){ //Se o tipo for 1, imprime as Strings em maiusculo
				escritor.println(leitor.nextLine().toUpperCase());
			}
			else{ //Se o tipo no for -1, nem 0, nem 1, imprime o ficheiro fileIn
				escritor.println(leitor.nextLine());
			}
		}
		leitor.close();
		escritor.close();
	}

	/**
	 * 
	 * Metodo usado para retirar caracteres predefinidos
	 * no ficheiro fileLeras do ficheiro fileIn e imprimir
	 * o resultado no ficheiro fileOut
	 * 
	 * @param fileIn ficheiro de leitura
	 * @param fileLetras ficheiro com os caracteres
	 * 					 que vao ser removidos do ficheiro de leitura
	 * @param fileOut fichiro de escrita
	 * @throws IOException
	 * @requires fileIn != null && fileOut != null && fileLetras != null
	 */
	public static void retiraCaracteres(String fileIn, String fileLetras, String fileOut) throws IOException{

		Scanner leitor = new Scanner(new File(fileIn));
		Scanner leitor2 = new Scanner(new File(fileLetras));
		PrintWriter escritor = new PrintWriter(fileOut);

		String caracteres = leitor2.next(); //Atribui ah String, os caracteres do ficheiro fileLetras

		while(leitor.hasNextLine()){ //Enquanto o proximo token for uma String
			String subChar= leitor.nextLine().replaceAll(caracteres, ""); //Substitui os caracteres da String

			escritor.println(subChar.replaceAll(" ", ""));

		}
		leitor.close();
		leitor2.close();
		escritor.close();
	}

	/**
	 * 
	 * Metodo usado para substituir no ficheiro fileIn os numeros
	 * por letras, ou seja, os numeros em extenso e tambem para
	 * remover pontos, virgulas e espacos e imprimir o
	 * resultado no ficheiro fileOut
	 * 
	 * @param fileIn ficheiro de leitura
	 * @param fileOut ficheiro de escrita
	 * @throws IOException
	 * @requires fileIn != null && fileOut != null
	 */
	public static void numerosPorLetras (String fileIn, String fileOut) throws IOException{

		Scanner leitor = new Scanner(new File(fileIn));
		PrintWriter escritor = new PrintWriter(fileOut);

		while(leitor.hasNextLine()){ //Enquanto o proximo token for uma String
			String read = leitor.nextLine();
			StringBuilder sb = new StringBuilder();

			for(int i = 0; i < read.length(); i++){ //Vai percorrer a String read
				//Remove pontos, virgulas e espacos
				if(read.charAt(i) == '.' || read.charAt(i) == ',' || read.charAt(i) == ' '){ 
					sb.append("");
				}
				else if(read.charAt(i) == '0'){ //Se o caracter for 0, vai adicionar ah StringBuilder
					//a String zero
					sb.append("zero");
				}
				else if(read.charAt(i) == '1'){
					sb.append("um");
				}
				else if(read.charAt(i) == '2'){
					sb.append("dois");
				}
				else if(read.charAt(i) == '3'){
					sb.append("tres");
				}
				else if(read.charAt(i) == '4'){
					sb.append("quatro");
				}
				else if(read.charAt(i) == '5'){
					sb.append("cinco");
				}
				else if(read.charAt(i) == '6'){
					sb.append("seis");
				}
				else if(read.charAt(i) == '7'){
					sb.append("sete");
				}
				else if(read.charAt(i) == '8'){
					sb.append("oito");
				}
				else if(read.charAt(i) == '9'){
					sb.append("nove");
				}
				else
					sb.append(read.charAt(i)); //Caso nao se verifique nenhum dos casos anteriores,
				//adiciona ah StringBuilder a String read
			}
			escritor.println(sb.toString());
		}
		leitor.close();
		escritor.close();
	}

	/**
	 * 
	 * Metodo usado para efetuar a rotacao de cada uma das letras,
	 * segundo um valor rotacao de quanto, elimina ponto, virgulas e
	 * espacos e imprime o resultado no ficheiro fileOut 
	 * 
	 * @param fileIn ficheiro de leitura
	 * @param fileOut ficheiro de escrita
	 * @param quanto valor da rotacao das letras
	 * @throws IOException
	 * @requires fileIn != null && fileOut != null
	 */
	public static void rotacao (String fileIn, String fileOut, int quanto) throws IOException{

		Scanner leitor = new Scanner(new File(fileIn));
		PrintWriter escritor = new PrintWriter(fileOut);

		while(leitor.hasNextLine()){ //Enquanto o proximo token for uma String
			String Text = leitor.nextLine();
			String text = Text.toLowerCase(); //Vai transformar a String Text em letras minusculas
			StringBuilder sb = new StringBuilder(text);

			for(int i = 0; i < sb.length(); i++){
				int rotation = ((int) sb.charAt(i)) + quanto;

				//Remove pontos, virgulas e espacos
				if(sb.charAt(i) == '.' || sb.charAt(i) == ',' || sb.charAt(i) == ' '){
					sb.deleteCharAt(i);
				}
				else if(rotation < (char) 'z'){ //Se o valor da rotacao for inferior a z
					//substitui o char na posicao i pelo char rotation
					//ou seja, faz uma rotacao para a frente
					sb.setCharAt(i, (char) rotation);
				}
				else if(rotation > (char) 'z'){ //Se o valor da rotacao for superior a z
					//substitui o char na posicao i pelo char (z-rotation)
					//ou seja, faz uma rotacao para tras
					sb.setCharAt(i, (char) ('z' - rotation));
				}
			}
			escritor.print(sb);
		}
		leitor.close();
		escritor.close();
	}

	/**
	 * 
	 * Metodo usado para efetuar a contagem da frequencia
	 * relativa de cada letra e dependendo do valor do tipo,
	 * imprimir no ficheiro fileOut pela ordem descrita
	 * para cada valor tipo
	 * 
	 * @param fileIn ficheiro de leitura
	 * @param fileOut ficheiro de escrita
	 * @param tipo inteiro para escolher a apresentacao da escrita
	 * @throws IOException
	 * @requires fileIn != null && fileOut != null && tipo >= 0 && tipo <= 1 
	 */
	public static void frequenciasLetras(String fileIn, String fileOut, int tipo) throws IOException{

		Scanner leitor = new Scanner(new File(fileIn));
		PrintWriter escritor = new PrintWriter(fileOut);

		while(leitor.hasNextLine()){ //Enquanto o proximo token for uma String
			int count = 0;
			String Read = leitor.nextLine();
			String read = Read.toLowerCase(); //Vai transformar a String Read em letras minusculas

			//Vai percorrer dois ciclos e comparar o String na posicao i
			//com a String na posicao j, se forem iguais, adiciona +1
			//ao inteiro count
			for(int i = 0; i < read.length(); i++){ 
				for(int j = 0; j < read.length(); j++){
					if(read.charAt(i) == read.charAt(j)){
						count++;
					}
				}
				double freq = count/read.length();
				if(tipo == 0){
					escritor.println(read.charAt(i) + " " + freq);
				}
			}
		}
		leitor.close();
		escritor.close();
	}

}

