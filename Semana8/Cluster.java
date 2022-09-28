import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Nuno Fontes n46413
 *
 */
public class Cluster {
	
	private Element centroid;
	private String s;
	private ArrayList<Element> element;
	private String label;


    /**
     * Cria um grupo (cluster) dado um elemento que serve de centroide
     * e a sua designacao
     * @param centroid - o elemento que serve de centroide
     * @param s - a designcacao do cluster
     * @requires centroid, s != null
     */
    public Cluster (Element centroid, String s) {
    	this.centroid = centroid;
    	this.s = s;
    	this.element = new ArrayList<>();
    	this.label = this.centroid.getLabel();
    }

    /**
     * Cria um grupo (cluster) dado um elemento que serve de centroide
     * e a sua designacao
     * @param centroid - o elemento que serve de centroide
     * @param s - a designcacao do cluster
     * @requires centroid, s != null
     */
    public boolean add(Element e) {
        return this.element.add(e);
    }

    /**
     * O elemento ja pertence ao cluster
     * @param e - o elemento a testar
     * @return true sse e ja existe ni cluster
     * @requires e != null
     */
    public boolean contains(Element e) {
        return this.element.contains(e);
    }

    /**
     * Este cluster tem elementos? 
     * @return true se nao ha elementos no cluster
     */
    public boolean isEmpty() {
        return this.element.isEmpty();
    }

    /**
     * Informa o numero de elementos deste cluster
     * @return o numero de elmentos no cluster
     */
    public int size() {
        return this.element.size();
    }



    /**
     * Da uma forma de iterar sobre os elementos do cluster
     * @return um iterador sobre os elementos deste cluster
     */
    public Iterator<Element> iterator(){
        return this.element.iterator();
    }


    /**
     * Devolve a classificacao atribuida
     * @return a classificacao dada
     */
    public String getLabel () {
        return this.label;
    }


    /**
     * Actualiza a classificacao deste cluster
     * @param label a classificacao dada ao cluster
     * @requires label != null
     */
    public void setLabel (String label) {
    	this.label = label;
    }


    /**
     * Devolve copia dos elementos do cluster 
     * @return uma copia dos elementos deste cluster
     */
    public ArrayList<Element> getElements () {
    	@SuppressWarnings("unchecked")
		ArrayList<Element> copia = (ArrayList<Element>) element.clone();
        return copia;
    }


    /**
     * Uma copia do centroide deste cluster
     * @return uma copia do centroide
     */
    public Element getCentroid () {
    	return this.centroid.clone();
    }

    /**
     * Actualiza o centroide de acordo com a media dos elementos 
     * deste cluster 
     * @requires !isEmpty()
     */
    public void updateCentroid() {
    	double[] a = new double[this.centroid.getFeaturesSize()];
    	for(int i = 0; i < a.length; i++){
    		double[] b = new double[element.size()];
    		for(int j = 0; j < b.length; j++){
    			b[j] = element.get(j).getFeatures()[i];
    		}
    		a[i] = media(b);
    	}
    	this.centroid = (new Element("Centroid " + this.label, a, this.label, 1));
    }
    
    /**
     * Metodo auxiliar para calcular a media
     * @param a - vetor de doubles
     * @return media
     */
    private double media(double[] a){
    	double media = 0.0;
    	for(double b : a){
    		media += b/a.length;
    	}
    	return media;
    }

    /**
     * Actualiza o centroide deste cluster para um dado elemento 
     * @param e o novo centroide
     * @requires e != null
     */
    public void setCentroid (Element e) {
    	this.centroid = e.clone();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString () {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Cluster " + this.s + ":\n");
    	for(Element e : element){
    		sb.append("    " + e.toString() + "\n");
    	}
    	sb.append("centroid =" + centroid.toString() + "\n");
        return sb.toString();
    }


    /**
     * Calcula a variancia deste cluster
     * @return Raiz quadrada da soma do quadrado das distancias de todos os elementos 
     *          ao centroide deste cluster 
     * @requires !isEmpty()
     */
    public double variance () {
    	double soma = 0.0;
    	for(Element e : element){
    		soma += Math.pow(e.distance(centroid), 2);
    	}
        return Math.sqrt(soma);
    }

}
