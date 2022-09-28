import static org.junit.Assert.*;

import org.junit.Test;

public class PolinomioTestesProduto {

    private Polinomio p1;
    private Polinomio p2;
    private Polinomio esperado;
    private Polinomio obtido;

    @Test(timeout = 10000)
    public void AmbosGrau0 () {
        Fracao[] coefs= new Fracao[1];
        coefs[0] = new Fracao(3,2);
        p1 = new Polinomio (coefs);
        p2 = new Polinomio (coefs);
        coefs[0] = new Fracao(9,4);
        esperado = new Polinomio (coefs);
        obtido = p1.produto(p2);
        assertTrue(esperado.ehIgual(obtido));
    }
    
    @Test(timeout = 10000)
    public void grau1MultiplicadoPorGrau0 () {
        Fracao[] coefs= new Fracao[2];
        coefs[0] = new Fracao(3,2);
        coefs[1] = new Fracao(1,2);
        p1 = new Polinomio (coefs);
        
        coefs= new Fracao[1];
        coefs[0] = new Fracao(1,2);
        p2 = new Polinomio (coefs);
        
        coefs= new Fracao[2];
        coefs[0] = new Fracao(3,4);
        coefs[1] = new Fracao(1,4);
        esperado = new Polinomio (coefs);
        obtido = p1.produto(p2);
        assertTrue(esperado.ehIgual(obtido));
    }
    
    
    @Test(timeout = 10000)
    public void grau1ProdutoPorGrau1 () {
        Fracao[] coefs= new Fracao[2];
        coefs[0] = new Fracao(1,1);
        coefs[1] = new Fracao(1,1);
        p1 = new Polinomio (coefs);
        
        coefs= new Fracao[2];
        coefs[0] = new Fracao(2,1);
        coefs[1] = new Fracao(2,1);
        p2 = new Polinomio (coefs);
        
        coefs= new Fracao[3];
        coefs[0] = new Fracao(2,1);
        coefs[1] = new Fracao(4,1);
        coefs[2] = new Fracao(2,1);
        esperado = new Polinomio (coefs);
        obtido = p1.produto(p2);
        assertTrue(esperado.ehIgual(obtido));
    }
    
    @Test(timeout = 10000)
    public void grau1MultiplicadoPorGrauMaior1 () {
        Fracao[] coefs= new Fracao[2];
        coefs[0] = new Fracao(1,1);
        coefs[1] = new Fracao(1,1);
        p1 = new Polinomio (coefs);
        
        coefs= new Fracao[3];
        coefs[0] = new Fracao(0,1);
        coefs[1] = new Fracao(0,1);
        coefs[2] = new Fracao(1,1);
        p2 = new Polinomio (coefs);

        //x + 1 * x^2 
        
        coefs= new Fracao[4];
        coefs[0] = new Fracao(0,1);
        coefs[1] = new Fracao(0,1);
        coefs[2] = new Fracao(1,1);
        coefs[3] = new Fracao(1,1);
        esperado = new Polinomio (coefs);
        obtido = p1.produto(p2);
        assertTrue(esperado.ehIgual(obtido));
    }
    
    
}
