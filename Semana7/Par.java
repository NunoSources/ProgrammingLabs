
/**
 * Classe imutavel para representar um par de elementos ordenada
 * @author Nuno Fontes n46413
 *
 * @param <E> O tipo dos items
 * @param <F> O tipo dos items
 */
public class Par<E, F> {

	private E e;
	private F f;
	
    /**
     * Cria um par imutavel com os dois items dados
     * @param e O primeiro elemento
     * @param f O segundo elemento do par
     */
    public Par(E e, F f) {
    	this.e = e;
    	this.f = f;
    }


    /**
     * @return O primeiro elemento do par
     */
    public E primeiro( ) {
        return this.e;
    }


    /**
     * @return O segundo elemento do par
     */
    public F segundo() {
        return this.f;
    }

    /**
     * Devolve a representacao do par na forma [E, F]
     */
    @Override
    public String toString() {
        return "[" + this.e + ", " + this.f + "]";
    }

    /**
     * @param obj o outro objecto
     * @return true sse este objecto eh igual a obj
     */
    @Override
    public boolean equals(Object obj) {        
    	
        return false;
    }

}
