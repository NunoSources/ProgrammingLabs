
/**
 * @author Nuno Fontes , n 46413
 *
 */
public class RunSemana2 {
    
    public static void main (String[] args) {
    	
    	 Fracao[] coefs= new Fracao[1];
         coefs[0] = new Fracao(3,2);
         Polinomio p11 = new Polinomio (coefs);
         coefs[0] = new Fracao(6,5);
         Polinomio p22 = new Polinomio (coefs);
         
         System.out.println(p11);
         System.out.println(p22);
    	
    	/*Fracao fr1 = new Fracao (1, 2);
    	Fracao fr2 = new Fracao (3, 1);
    	Fracao fr3 = new Fracao (-8, 4);
    	
    	Fracao[] coefs = {fr1, fr2};
    	Fracao[] coefs2 = {fr2, fr3};
    	Fracao[] coefs3 = {fr1, fr2, fr3};
    	
    	Polinomio p1 = new Polinomio(coefs);
    	Polinomio p2 = new Polinomio(coefs3);
    	
    	System.out.println(p1);
    	System.out.println(fr2);
    	System.out.println(p2);
    	System.out.println(fr3);*/

    }

}
