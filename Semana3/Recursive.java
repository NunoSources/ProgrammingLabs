
/**
 * @author Nuno Fontes, n 46413
 *
 */
public class Recursive {

    /**
     * @param base valor da base da potencia
     * @param expoente valor do expoente da potencia
     * @return valor 1 se base == 1 || expoente == 0, caso contrario, retorna
     *         o valor da potencia de base = base e expoente = expoente
     */
    public static double potencia (double base, int expoente) {
        if(base == 1 || expoente == 0)
        	return 1;
        else
            return base * potencia(base, expoente - 1);
    }

    /**
     * 
     * Metodo para calcular a soma de todos os numeros nao negativos ate n
     * 
     * @param n valor do inteiro n
     * @return valor da soma de todos os numeros nao negativos ate n
     */
    public static int soma (int n) {
        if(n == 0)
            return 0;
        else if(n > 0)
            return soma(n-1) + n;
        else
            return soma(n-1);
    }

    public static int maior (int[] v) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static int countChar (String s, char c) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static String change (String s, char old, char newer) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param p inteiro de valor p
     * @param q inteiro de valor q
     * @return maximo divisor comum de dois inteiros, p e q
     */
    public static int gcd (int p, int q) {
        if(q == 0 || p == q)
            return p;
        else if(p > q || p == q)
            return gcd(q, p % q);
        else
            return gcd(q, p);
    }

    public static int binomial (int l, int k) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 
     * Metodo usado para verificar se o inteiro de valor n, pertence ao vetor v
     * 
     * @param v vetor de inteiros
     * @param n inteiro de valor n
     * @return true se n == v[i] e false caso contrario
     */
    public static boolean pertence (int[] v, int n) {
        for(int i = 0; i < v.length; i++){
            if(v[i] == n)
                return true;
        }
        return false;
    }


    /**
     * 
     * Metodo usado para verificar se o vetor eh simetrico
     * 
     * @param v vetor de inteiros
     * @return 
     */
    public static boolean ehSimetrico (int[] v) {
        return arraySimetrico(v, 0);
    }
    
    /**
     * @param v vetor de inteiros
     * @param i inteiro de valor i
     * @return true se o valor i for igual ao tamanho do vetor, sem termos recebido
     *          nenhum false, false se o valor na posicao i do vetor, for diferente 
     *          na posicao contraria do vetor
     */
    public static boolean arraySimetrico(int[] v, int i){
        if(i == v.length)
            return true;
        else if(v[i] != v[v.length - 1 - i])
            return false;
        else
            return arraySimetrico(v, i + 1);
    }
 
    public static boolean ehCrescente (double[] v) {
        // TODO Auto-generated method stub
        return false;
    }

    public static String intToBin (int n) {
        // TODO Auto-generated method stub
        return null;
    }

    public static int triangulos (int l) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static int numeroOrelhas (int l) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static int algarismos (int l) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    public static int somaAlgarismos (int l) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static boolean ehPrimo (int n) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * 
     * Metodo usado para calcular o produto de dois inteiros
     * 
     * @param n valor do inteiro n
     * @param m valor do inteiro m
     * @return 0 se um dos inteiros for igual a 0, se m for negativo, retorna o valor do
     *          produto de n com m, mas com valor negativo, caso contrario, retorna 
     *          o produto de n com m, mas de valor positivo
     */
    public static int produto (int n, int m) {
        if(n == 0 || m == 0)
            return 0;
        else if(m < 0)
            return -n + produto(n, m+1);
        else
            return n + produto(n, m-1);
    }

    public static int somaQuadrados (int n) {
        // TODO Auto-generated method stub
        return 0;
    }
}
