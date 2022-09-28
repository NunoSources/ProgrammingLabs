

import java.io.IOException;

/**
 * Exemplo de como ler um ficheiro de inteiros (um por linha),
 * processar o seu conteudo, e escrever o resultado noutro ficheiro.
 *
 * @author ASouto, adaptado de Isabel Nunes 
 *
 */
public class RunSemana0 {

    private static String nomeFicheiroIn;
    private static String nomeFicheiroOut;
    private static final String FICHEIRO = "numeros.txt";

    /**
     * Abre um ficheiro para leitura e outro para escrita. Le do primeiro, aplica uns metodos,
     * e escreve o resultado no segundo ficheiro.
     */

    public static void main(String[] args) throws Exception {

        // canal de leitura
        nomeFicheiroIn = FICHEIRO;
        nomeFicheiroOut = "dobros.txt";

        ExemploFicheiros.calculaDobro(nomeFicheiroIn);

        //Agora os pares!

        nomeFicheiroIn = FICHEIRO;
        nomeFicheiroOut = "pares.txt";

        //escreve para o ficheiro dobro.txt apenas os que sao pares de numeros.txt
        ExemploFicheiros.guardaPares(nomeFicheiroIn, nomeFicheiroOut);

        //Agora ficheiros com texto.
        nomeFicheiroIn = "texto.txt";
        nomeFicheiroOut = "copia.txt";

        ExemploFicheiros.copiaTexto(nomeFicheiroIn, nomeFicheiroOut);

        //Transformar tudo em minusculas
        nomeFicheiroIn = "texto.txt";
        nomeFicheiroOut = "minusculas.txt";

        ExemploFicheiros.tudoMinusculas (nomeFicheiroIn, nomeFicheiroOut);

        //Um pouco mais trabalhoso
        //Metodo que guarda quantas vezes aparecem cada potencia de 10 entre 1 e 10^(n-1), isto eh,
        //quantas vezes aparece o 1, 10, 100, ..., 10^(n-1), um por linha

        nomeFicheiroIn = FICHEIRO;
        nomeFicheiroOut = "potencias.txt";

        ExemploFicheiros.potenciasDe10(nomeFicheiroIn, nomeFicheiroOut, 5);
    }
}
