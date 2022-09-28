import java.util.ArrayList;
import java.util.Random;

/**
 * @author Nuno Fontes n46413
 *
 */
public class KMeanClustering {


	public static final int ITERATIONS = 100;

	public static final double DELTA = 0.0001;

	private ArrayList<Cluster> list;
	private Cluster[] grupos;

	/**
	 * Cria uma instancia de KMeanClustering agrupando
	 * os elementos de uma dada lista em cluster
	 * @param lista - o conjunto de elementos
	 * @param centroidesIniciais a lista com os centroides iniciais
	 * @requires lista != null e todos os seus elementos nao null
	 *          centroidesIniciais != null 
	 */
	public KMeanClustering(ArrayList<Element> lista, ArrayList<Element> centroidesIniciais) {
		this.list = new ArrayList<>();
		for(Element centroid : centroidesIniciais){
			Cluster cluster = new Cluster(centroid, Integer.toString(centroid.getType()));
			this.list.add(cluster);
		}
		adicionaClusters(lista);
	}

	/**
	 * Metodo auxiliar para adicionar elementos a um cluster de acordo com 
	 * a menor distancia para o centroid do cluster
	 * @param outraLista conjunto de elementos
	 * @requires outraLista != null
	 */
	private void adicionaClusters(ArrayList<Element> outraLista){
		for(Element e : outraLista){
			Cluster outroCluster = null;
			for(Cluster cluster : this.list){
				Element centroid = cluster.getCentroid();
				if(e.distance(centroid) <= DELTA){
					outroCluster = cluster;
				}
			}
			outroCluster.add(e);
			outroCluster.updateCentroid();
		}
	}

	/**
	 * Inicializa uma instancia de KMeanClustering agrupando
	 * os elementos de uma dada lista em cluster com centroides escolhidos aleatoriamente
	 * Nao se esqueca de alterar a label do cluster/centroide de acordo com a maioria dos seus elementos
	 * @param lista - o conjunto de elementos
	 * @param numClers o numero de centroides iniciais
	 * @requires lista != null e todos os seus elementos nao null
	 *          numCluster > 0 
	 */          
	public KMeanClustering(ArrayList<Element> lista, int numClusters) {
		Random random = new Random();
		ArrayList<Element> novaLista = new ArrayList<>();
		for(int i = 0; i < numClusters; i++){
			int valor = random.nextInt(lista.size());
			novaLista.add(lista.get(valor));
		}
	}

	/**
	 * Devolve uma arrayList com os elementos da lista escalados para uma normal de media proximo de 0 e 
	 * desvio padrao proximo de 1.
	 * @param lista - a lista de elementos a renormalizar
	 * @return uma lista com elementos renormalizados para uma media aproximada de 0 e 
	 * desvio padrão de aproximada 1. (x --> (x - media)/desvio
	 */
	public static ArrayList<Element> rescale (ArrayList<Element> lista) {
		ArrayList<Element> elementos = new ArrayList<>();
		double[] media = calculoMedia(lista);
		@SuppressWarnings("unused")
		double[] desvioPadrao = calculoStdDev(lista, media);
		for(int i = 0; i < lista.size(); i++){
			elementos.add(new Element(lista.get(i).getName(), 
					                  lista.get(i).getFeatures(), 
					                  "not given", lista.get(i).getType()));
		}
		return elementos;
	}

	/**
	 * Metodo auxiliar usado para efetuar a atualizacao dos centroids
	 * @param features dados do elemento
	 * @param media - media
	 * @param desvioPadrao - desvio padrao
	 */
	/*private static void atualizar(double[] features, double[] media, double[] desvioPadrao){
		ArrayList<Element> lista = new ArrayList<>();
		for(int i = 0; i < lista.size(); i++){
			features[i] = (features[i] - media[i]) / desvioPadrao[i];
		}
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		ArrayList<Element> lista = new ArrayList<>();
		sb.append("Clusters Produced:  \n");
		for(int i = 0; i < grupos.length; i++){
			sb.append("Cluster " + grupos[i].getLabel() + ": \n");
			sb.append("Centroid " + grupos[i].getLabel() + " ")
			  .append(lista.get(i).getFeatures() + "\n");
			for(int j = 0; j < lista.get(i).getFeaturesSize(); j++){
				sb.append("    " + grupos[i].toString() + "\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Calcula a dissimilaridade dos grupos
	 * @return a soma das variancias dos cluster deste KMeanClustering
	 */
	public double dissimilarity() {
		double soma = 0.0;
		for(int i = 0; i < grupos.length; i++){
			soma += grupos[i].variance();
		}
		return soma;
	}

	/**
	 * Determina com base na pre-classificacao o numero de elementos
	 * colocados nos clusters errados
	 * @return o numero de erros do cluster
	 */
	public int numWrongClassifications(){
		int quantos = 0;
		for(int i = 0; i < grupos.length; i++){
			int a = Integer.parseInt(grupos[i].getLabel());
			for(int j = 0; j < grupos[i].getElements().size(); j++){
				if(a != grupos[i].getElements().get(j).getType()){
					quantos++;
				}
			}
		}
		return quantos;
	}

	/**
	 * Calcula o desvio padrao de um conjunto de dados
	 * @param lista - o conjunto de dados
	 * @param res - onde guarda os valores do desve cada clusterio padrao de cada ma das componentes
	 * @return
	 */
	private static double[] calculoStdDev (ArrayList<Element> lista, double[] medias) {

		double[] featuresStdDev = new double [lista.get(0).getFeaturesSize()];

		for (Element e: lista) {
			double[] elemfeat = e.getFeatures();
			for (int i = 0; i < featuresStdDev.length; i++) {
				featuresStdDev[i] += Math.pow(elemfeat[i] - medias[i],2);
			}
		}

		for (int i = 0; i < featuresStdDev.length; i++) {
			featuresStdDev[i] = Math.sqrt(featuresStdDev[i] / lista.size());
		}

		return featuresStdDev;

	}

	/**
	 * Calcula a media de um conjunto de dados
	 * @param lista - o conjunto de dados
	 * @param res - onde guarda os valores da media de cada ma das componentes
	 * @return
	 */
	private static double[] calculoMedia (ArrayList<Element> lista) {
		double[] featuresMedia = new double [lista.get(0).getFeaturesSize()];

		//primeiro somar
		for (Element e: lista) {
			double[] elemfeat = e.getFeatures();
			for (int i = 0; i < featuresMedia.length; i++) {
				featuresMedia[i] += elemfeat[i];
			}
		}

		//depois dividir por quantos ha
		for (int i = 0; i < featuresMedia.length; i++) {
			featuresMedia[i] = featuresMedia[i]/(lista.size());
		}

		return featuresMedia;
	}


}
