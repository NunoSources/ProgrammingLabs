
/**
 * 
 * @author Nuno Fontes , n 46413
 *
 */
public class Fracao {

	private int numerador;
	private int denominador;

	/**
	 * 
	 * @param num numerador da fracao
	 * @param den denominador da fracao
	 * @requires 
	 */
	public Fracao(int num, int den) {
		this.numerador = num;
		this.denominador = den;
	}

	/**
	 * 
	 * Verifica se a fracao dada eh igual a zero
	 * 
	 * @return true se a fracao representa o numero zero
	 * @requires
	 */
	public boolean ehZero() {
		if(this.numerador/this.denominador == 0){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * 
	 * Verifica se a fracao dada eh um inteiro
	 * 
	 * @return true se a fracao representa um numero inteiro
	 * @requires
	 */
	public boolean ehInteira() {
		if(this.numerador%this.denominador == 0){ //se o resto da divisao for
												  //igual a zero, eh um inteiro
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * 
	 * Verifica se a fracao dada eh positiva
	 * 
	 * @return true se a fracao representa um numero positivo
	 * @requires
	 */
	public boolean ehPositiva() {
		if((this.numerador/this.denominador) > 0){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * 
	 * Inverte a fracao dada
	 * 
	 * @return uma fracao inversa desta fracao
	 * @requires
	 */
	public Fracao inversa() {
		Fracao invFracao = new Fracao(this.denominador, this.numerador);
		return invFracao;
	}	

	/**
	 * 
	 * Efetua a soma da fracao dada com a fracao f
	 * 
	 * @param f fracao f dada
	 * @return uma fracao que eh a soma desta fracao com a fracao f
	 * @requires
	 */
	public Fracao soma(Fracao f) {
		Fracao somaFracao = new Fracao(this.numerador * f.denominador +
				f.numerador * this.denominador,
				this.denominador * f.denominador);
		return somaFracao;
	}

	/**
	 * 
	 * Efetua a multiplicacao da fracao dada com a fracao f
	 * 
	 * @param f fracao f dada
	 * @return uma fracao que eh o produto desta fracao com a fracao f
	 * @requires
	 */
	public Fracao produto(Fracao f) {
		Fracao multFracao = new Fracao(this.numerador * f.numerador,
				this.denominador * f.denominador);
		return multFracao;
	}


	/**
	 * 
	 * Efetua a divisao da fracao dada com a fracao f
	 * 
	 * @param f fracao f dada
	 * @return uma fracao que eh a divisao desta fracao com a fracao f
	 * @requires
	 */
	public Fracao divisao(Fracao f) {
		Fracao divFracao = new Fracao(this.numerador * f.denominador,
				f.numerador * this.denominador);	
		return divFracao;
	}

	/**
	 * Criacao de uma copia da fracao
	 * @return uma nova fracao igual ao this.
	 */
	public Fracao copia() {
		Fracao copiaFracao = new Fracao(this.numerador, this.denominador);
		return copiaFracao;
	}

	/**
	 * 
	 * @param f fracao f dada
	 * @return true se esta fracao representa o mesmo numero que a fracao f
	 * @requires 
	 */
	public boolean equivalente (Fracao f) {
		//se o resultado das duas fracoes for igual, entao as fracoes
		//sao equivalentes
		if(this.numerador/this.denominador == f.numerador/f.denominador){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * 
	 * Devolve uma representacao textual desta fracao, na forma simplificada
	 * 
	 */
	public String toString() {
		StringBuilder textFracao = new StringBuilder();

		if(this.numerador == this.denominador){
			textFracao.append(1);
		}
		else if(this.denominador == 1){ //se o denominador for 1, apenas se
										//apresenta o numerador
			textFracao.append(this.numerador);
		}
		else if(this.numerador % 2 == 0 && this.denominador % 2 == 0){
			textFracao.append(this.numerador/2)
			.append("/")
			.append(this.denominador/2);
		}
		else if(this.numerador > 0 && this.denominador > 0 ||
				this.numerador < 0 && this.denominador > 0){
			textFracao.append(this.numerador)
			.append("/")
			.append(this.denominador);
		}
		else if(this.numerador < 0 && this.denominador < 0 ||
				this.numerador > 0 && this.denominador < 0){
			textFracao.append(-this.numerador)
			.append("/")
			.append(-this.denominador);
		}
		else if(this.numerador/this.denominador == 0){
			textFracao.append(0);
		}

		return textFracao.toString();
	}

	/**
	 * 
	 * @param f fracao f dada
	 * @return 
	 * @requires
	 */
	public static Fracao makeFromString(String f) {




		return null;
	}

	public int getNumerador(){
		return this.numerador;
	}

	public int getDenominador(){
		return this.denominador;
	}

}
