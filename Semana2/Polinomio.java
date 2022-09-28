
/**
 * 
 * @author Nuno Fontes , n 46413
 *
 */
public class Polinomio {
	private Fracao[] coefs;

	/**
	 * 
	 * @param coefs coeficientes dados
	 * @requires
	 */
	public Polinomio(Fracao[] coefs) {
		this.coefs = coefs;
	}

	/**
	 * 
	 * Verifica o valor do grau do polinomio
	 * 
	 * @return grau deste polinomio
	 * @requires this.coefs.length > 0
	 */
	public int grau() {
		return this.coefs.length - 1; //tamanho do polinomio, menos um, do tamanho
									  //da constante
	}


	/**
	 * 
	 * Verifica se o polinomio eh zero
	 * 
	 * @return true se este polinomio for o polinomio zero
	 * @requires this.coefs.length >= 0
	 */
	public boolean ehZero() {
		for(int i = 0; i < this.coefs.length;i++){
			if(i != 0){ //se o valor do i nao for zero, entao o polinomio nao
						//eh zero
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * Verifica se o polinomio eh constante, grau = 0, tem apenas o
	 * tamanho da constante
	 * 
	 * @return true se este polinomio for constante
	 * @requires this.coefs.length >= 0
	 */
	public boolean ehConstante() {
		if(this.coefs.length == 1){ //para ser constante, o grau tem de ser zero,
									//se o valor do tamanho do polinomio for um,
									//representa o tamanho da constante
			return true;
		}
		else{
			return false;
		}

	}


	/**
	 * 
	 * Verifica se os polinomios sao iguais
	 * 
	 * @param p polinomio p dado
	 * @return true se este polinomio for igual ao polinomio dado
	 * @requires this.coefs.length >= 0
	 */
	public boolean ehIgual(Polinomio p) {
		for(int i = 0; i < this.coefs.length; i++){
			if(this.coefs[i] != p.coefs[i]){ //vai verificar em cada valor i,
											 //se o coeficiente do polinomio dado
											 //eh igual ao coeficiente do polinomio
											 //p, se algum dos coeficientes na
											 //mesma posicao, nao coincidir,
											 //retorna falso
				return false;
			}
		}
		return true;
	}


	/**
	 * 
	 * Calcula a multiplicacao de uma polinomio com uma escalar
	 * 
	 * @param f fracao f dada
	 * @return polinomio que corresponde ah multiplicacao deste polinomio 
	 * 		   por um escalar
	 * @requires this.coefs.length >= 0
	 */
	public Polinomio escalar(Fracao f) {
		Polinomio multEscalar = new Polinomio(this.coefs);
		for(int i = 0; i < this.coefs.length; i++){
			//vai percorrer cada coeficiente do polinomio dado e multiplicar
			//com a fracao f
			multEscalar.coefs[i] = multEscalar.coefs[i].produto(f);
		}
		return multEscalar;      
	}

	/**
	 * 
	 * Calcula o polinomio simetrico
	 * 
	 * @return polinomio que corresponde ao polinomio simetrico deste polinomio
	 * @requires this.coefs.length >= 0
	 */
	public Polinomio simetrico() {
		Polinomio simPoli = new Polinomio(this.coefs);
		for(int i = 0; i < this.coefs.length; i++){
			//vai percorrer cada coeficiente do polinomio dado e multiplicar
			//por menos um, para alterar os sinais dos coeficientes
			simPoli.coefs[i] = simPoli.coefs[i].produto(-1);
		}
		return simPoli;
	}

	/**
	 * 
	 * Calcula a soma de dois polinomios
	 * 
	 * @param p polinomio p dado
	 * @return polinomio que corresponde ah soma deste polinomio
	 * 		   com o polinomio p dado
	 * @requires this.coefs.length >= 0
	 */
	public Polinomio soma (Polinomio p) {
		Polinomio somaPoli = new Polinomio(this.coefs);
		for(int i = 0; i < this.coefs.length; i++){
			//vai percorrer cada coeficiente do polinomio dado e somar com o
			//coeficiente do polinomio p na mesma posicao
			somaPoli.coefs[i] = somaPoli.coefs[i].soma(p.coefs[i]);
		}
		return somaPoli;
	}

	/**
	 * 
	 * Calcula a subtracao de dois polinomios
	 * 
	 * @param p polinomio p dado
	 * @return polinomio que corresponde ah subtracao deste polinomio com o
	 * 	 	   polinomio p dado
	 * @requires this.coefs.length >= 0
	 */
	public Polinomio subtraccao (Polinomio p) {
		Polinomio subPoli = new Polinomio(this.coefs);
		for(int i = 0; i < this.coefs.length; i++){
			//vai percorrer cada coeficiente do polinomio dado e somar com o 
			//valor simetrico do coeficiente do polinomio p na mesma posicao
			subPoli.coefs[i] = subPoli.coefs[i].soma(-p.coefs[i]);
		}
		return subPoli;
	}

	/**
	 * 
	 * @param p polinomio p dado
	 * @return polinomio que corresponde ah multiplicacao deste polinomio com o
	 * 	 	   polinomio p dado
	 * @requires this.coefs.length >= 0
	 */
	public Polinomio produto(Polinomio p) {
		Polinomio multPoli = new Polinomio(this.coefs);
		for(int i = 0; i < this.coefs.length; i++){
			//vai percorrer cada coeficiente do polinomio dado e multiplicar 
			//com o coeficiente do polinomio p na mesma posicao
			multPoli.coefs[i] = multPoli.coefs[i].produto(p.coefs[i]);
		}
		return multPoli;
	}

	/**
	 * 
	 * @param x fracao f dada
	 * @return
	 * @requires
	 */
	public Fracao avalia(Fracao x) {
		return null;
	}


	/**
	 * 
	 * Calcula a derivada de um polinomio
	 * 
	 * @return polinomio que corresponde ah derivada deste polinomio
	 * @requires this.coefs.length >= 0
	 */
	public Polinomio deriva() {
		Polinomio derivaPoli = new Polinomio(this.coefs);
		for(int i = 0; i < this.coefs.length; i++){
			//vai percorrer cada coeficiente do polinomio dado e efetuar a sua
			// derivada, multiplicando o coeficiente com o valor i do grau
			// nessa posicao
			derivaPoli.coefs[i-1] = derivaPoli.coefs[i].produto(i);
		}
		return derivaPoli;
	}


	/**
	 * 
	 * Obtem a copia de um polinomio
	 * 
	 * @return um novo polinomio igual ao this
	 * @requires
	 */
	public Polinomio copia() {
		Polinomio copiaPoli = new Polinomio(this.coefs);
		return copiaPoli;
	}


	/**
	 * Devolve uma representacao textual deste polinomio
	 */
	public String toString() {
		StringBuilder textPoli = new StringBuilder();

		for(int i = 0; i < this.coefs.length; i++){
			if(i == 0){
				textPoli.append(this.coefs[i]);
			}
			else if(this.coefs[i].ehPositiva()){
				textPoli.append(" + ")
				.append(this.coefs[i])
				.append("x^")
				.append(i+" ");
			}
			else if(this.coefs[i].ehZero()){
				textPoli.append("");
			}
			else{
				textPoli.append(this.coefs[i])
				.append("x^")
				.append(i+" ");
			}
		}

		return textPoli.toString();
	}
}

