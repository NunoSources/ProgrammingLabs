import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representacao de um pacote, i.e. um conjunto de items
 * @author Nuno Fontes n46413
 * @param <E> O tipo dos items
 */
public class Pacote<E> implements Iterable<E>, Cloneable {

	public static final int NUM_MAX_ITEMS = 3;
	private ArrayList<E> pacote;
	private double capacidade;
	private double ocupado;

	/**
	 * Constroi este pacote
	 * @param capcidade dimensao maxima que o pacote pode conter
	 * @requires capcidade > 0
	 */
	public Pacote(double capcidade) {
		this.capacidade = capcidade;
		pacote = new ArrayList<>(NUM_MAX_ITEMS);
	}

	/**
	 * Retorna a capacidade jah utilizada deste pacote
	 * @return capacidade jah utilizada deste pacote
	 */
	public double obtemCapacidadeOcupada() {
		return ocupado;
	}

	/**
	 * Retorna o numero de itens actualmente contidos neste pacote
	 * @return numero de itens contidos neste pacote
	 */
	public int obtemNumItems() {
		return pacote.size();
	}

	/**
	 * Diz se o pacote jah tem o numero maximo de items permitido
	 * @return verdadeiro se o pacote ja tiver 
	 * 		   atingido o numero maximo de items
	 */
	public boolean estaCheio() {
		return pacote.size() == NUM_MAX_ITEMS;
	}

	/**
	 * Diz se um item com uma dada dimensao cabe no pacote
	 * @param tamanho - tamanho do item que se pretende verificar se cabe
	 * @return verdadeiro se o pacote nao esta cheio e um item
	 *         com aquele tamanho ainda cabe neste pacote
	 * @requires tamanho > 0
	 */
	public boolean cabe(double tamanho) {
		return !estaCheio() && this.capacidade - pacote.size() >= tamanho;
	}

	/**
	 * Empacota um item se a caixa nao estiver cheia
	 * @param item - o item a ser empacotado
	 * @param dimensaoDoItem - o tamanho que o item tem
	 * @return false sse o item nao nao pode ser adicionado
	 * @requires item != null && dimensaoDoItem > 0
	 */
	public boolean empacota(E item, double dimensaoDoItem){
		if(cabe(dimensaoDoItem)){
			pacote.add(item);
			ocupado += dimensaoDoItem;
			return true;
		}
		return false;
	}

	/**
	 * Representacao textual dos items do pacote
	 */
	public String toString(){
		return this.pacote.toString();
	}

	/**
	 * Retorna um iterador capaz de atravessar todos os items deste pacote
	 */
	public Iterator<E> iterator() {
		return (Iterator<E>) new Iterador();
	}

	/**
	 * Classe privada para implementacao de iteradores, de modo a 
	 * ser possivel percorrer os elementos de uma classe
	 */
	private class Iterador implements Iterator<E>{
		private int index;

		private Iterador(){
			index = 0;
		}

		public E next(){
			if(hasNext()){
				return pacote.get(index++);
			}else{
				return null;
			}
		}
		public boolean hasNext(){
			return index < pacote.size();
		}
	}

	/**
	 * Retorna uma copia deste pacote
	 * @return uma copia deste pacote
	 */
	public Pacote<E> clone (){
		Pacote<E> novoPacote = new Pacote<E>(this.capacidade);
		Iterator<E> it = this.iterator();
		for(int i = 0; i < pacote.size(); i++){
			novoPacote.pacote.add(it.next());
		}
		return novoPacote;
	}

	/**
	 * Metodo que verifica se este objeto eh igual ao outro objeto
	 * @param obj o outro objecto
	 * @return true sse este objecto eh igual a obj
	 */
	@Override
	public boolean equals(Object obj) {
		@SuppressWarnings("unchecked")
		Pacote<E> outroPacote = (Pacote<E>) obj;
		if(this.capacidade != outroPacote.capacidade){
			return false;
		}else if(this.obtemCapacidadeOcupada() != outroPacote.obtemCapacidadeOcupada()){
			return false;
		}
		return true;
	}

}
