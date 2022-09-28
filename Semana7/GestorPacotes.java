import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Gere a criacao de pacotes e operacoes sobre eles
 * @author Nuno Fontes n46413
 * @param <E> O tipo dos items
 */
public class GestorPacotes<E> {

	// limite de erro para comparacao de doubles
	public static final double DELTA_ERROR = 0.001;
	private double capacidadePacotes;
	public ArrayList<Pacote<Par<E, Double>>> gestorPacotes;

	/**
	 * Cria um gestor de pacotes
	 * @param capacidadePacotes capacidade dos pacotes
	 * @requires capacidadePacotes > 0
	 */
	public GestorPacotes (double capacidadePacotes) {
		this.capacidadePacotes = capacidadePacotes;
		gestorPacotes = new ArrayList<>();
	}

	/**
	 * Cria pacotes a partir de uma lista de itens. Antes de criar
	 * um novo pacote para cada item deve verificar se esse item
	 * nao cabe num dos pacotes jah existente
	 * @param listaDeItems a lista dos itens e os respetivos tamanhos
	 * @requires listaDeItems != null
	 */
	public void criaPacotes (List<Par<E, Double>> listaDeItems) {
		Pacote<Par<E, Double>> pacote = new Pacote<>(listaDeItems.size());
		for(int i = 0; i < listaDeItems.size(); i++){
			if(pacote.estaCheio()){
				gestorPacotes.add(pacote);
				pacote = new Pacote<>(capacidadePacotes);
				pacote.empacota(listaDeItems.get(i), listaDeItems.get(i).segundo());
			}
			pacote.empacota(listaDeItems.get(i), listaDeItems.get(i).segundo());
		}
		gestorPacotes.add(pacote);
	}

	/**
	 * Diz quantos pacotes ha com capacidade ocupada maior que a dada
	 * @param capacidade - o valor que o pacote deve ter atingido
	 * @return quantidade de pacotes com capacidade ocupada maior que a dada
	 * @requires capacidade > 0
	 */
	public int quantosPacoteComACapacidade(double capacidade) {
		int quantos = 0;
		for(int i = 0; i < gestorPacotes.size(); i++){
			if(gestorPacotes.get(i).obtemCapacidadeOcupada() > capacidade){
				quantos++;
			}
		}
		return quantos;
	}

	/**
	 * Devolve uma lista de pacotes que contenham um dado item
	 * @param item o elemento a pesquisar
	 * @return Lista com copia dos pacotes que contenham o item
	 * @requires item != null
	 */
	@SuppressWarnings("unchecked")
	public List<Pacote<E>> pesquisaPacotes( E item ) {
		Pacote<Par<E, Double>> pacote;
		ArrayList<Pacote<E>> lista = new ArrayList<>();
		for(int i = 0; i < gestorPacotes.size(); i++){
			pacote = gestorPacotes.get(i);
			Iterator<Par<E, Double>> it = pacote.iterator();
			while(it.hasNext()){
				if(it.next().primeiro().equals(item)){
					lista.add((Pacote<E>) pacote);
				}
			}
		}
		return lista;
	}

	/**
	 * Representacao textual dos pacotes criados, um por linha
	 */
	public String toString(){
		return this.gestorPacotes.toString();
	}

}
