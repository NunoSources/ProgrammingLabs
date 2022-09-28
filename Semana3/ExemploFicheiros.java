
import java.io.*;
import java.util.Scanner;


public class ExemploFicheiros {

    private static int potencias[];
    private static calculadora aminhacalculadora;
    private static PrintWriter out;
    private static Scanner in;

    public static void copiaTexto (String fileIn, String fileOut) throws FileNotFoundException{
        in = new Scanner (new File(fileIn));
        out = new PrintWriter(fileOut);
        boolean novaLinha = in.hasNext();
        while (novaLinha){// enquanto o ficheiro nao terminar 
            out.println(in.nextLine());
            novaLinha = in.hasNext();
        }

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
    public static void guardaPares (String filein, String fileout) throws FileNotFoundException{
        in = new Scanner (new File(filein));
        out = new PrintWriter(fileout);
        while (in.hasNextInt()){    // enquanto o ficheiro nao terminar
            int valorobtido = in.nextInt();
            aminhacalculadora = new calculadora();
            aminhacalculadora.Ehpar(valorobtido);
            if (aminhacalculadora.Ehpar(valorobtido)) {
                out.println(valorobtido);
            }
        }
    }

    /**
     * regista o dobro de cada numero em in em out
     * @param in
     * @param out
     * @requires in!=null && out != null e in so com numeros  
     */
    public static void calculaDobro (String fileIn) throws FileNotFoundException {
        in = new Scanner (new File(fileIn));
        boolean fim = true;
        while (!fim){
            aminhacalculadora = new calculadora();
            int valor = in.nextInt();
            System.out.println(aminhacalculadora.dobro(valor));
        }
    }


    /**
     * calculo no numero de vezes que aparecem 1, 10, ..., 10^n
     * @param in - de onde ler os valores
     * @param out - o que escrever
     * @param n
     * @requires in, out != null, in so com inteiros.
     */
    public static void potenciasDe10 (String fileIn, String fileOut, int n) throws FileNotFoundException{
        in = new Scanner (new File(fileIn));
        out = new PrintWriter(fileOut);
        potencias = new int[n+1];
        while(in.hasNextInt()){
            int valor = in.nextInt();
            calculadora.EhPotenciaDe10(potencias, valor);
        }

        //agora coloco os valor no ficheiro!
        for (int i = potencias.length; i < potencias.length; i++) {
            out.println(potencias[i]);
        }
    }

    /**
     * Calcula o arredondamento dado um algarismo para a dezena mais proxima 
     * @param algarismo - representacao de um algarismo em String
     * @return 0 se 0 <= algarismo < 5 e 10 caso contrario
     * @requires 0 <= algarismo < 10
     */
    public static int metodo(String algarismo) {
        if(algarismo == "0")
            return 0;
        if(algarismo == "1")
            return 0;
        if(algarismo == "2") 
            return 0;
        if(algarismo == "3")
            return 0;
        if(algarismo == "4")
            return 0;
        else
            return 10;
    }
}