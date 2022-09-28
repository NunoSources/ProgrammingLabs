

public class Pair<E, F> {
	
	private E primeiro;
	private F segundo;
	
	public Pair(E primeiro, F segundo){
		this.primeiro = primeiro;
		this.segundo = segundo;
	}

	public E first() {
		return primeiro;
	}
	
	public F second() {
		return segundo;
	}
	
	public String toString() {
		return "(" + first() + ", " + second() + ") " ;
	}
}
