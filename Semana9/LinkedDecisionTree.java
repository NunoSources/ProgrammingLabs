import java.util.ArrayList;
import java.util.List;

/**
 * @author Nuno Fontes n46413
 *
 */
public class LinkedDecisionTree {

	private TreeNode root;


	private static class TreeNode {
		private Pair<String, Float> data;
		private TreeNode leftNode;
		private TreeNode rightNode;

		private TreeNode( Pair<String, Float> data, TreeNode left, TreeNode right) {
			this.data = data;
			this.leftNode = left;
			this. rightNode = right;
		}
	}

	private LinkedDecisionTree( TreeNode n ){
		this.root = n;
	}



	/* 
	 *
	 * A completar
	 *
	 */


	/**
	 * Metodo usado para transformar uma arvore de decisao representada 
	 * sobre um vetor numa arvore de decisao equivalente utilizando uma 
	 * estrutura ligada de nos
	 * @param vectArv lista que representa a arvore sobre um vetor
	 */
	public LinkedDecisionTree(ArrayList<Pair<String, Float>> vectArv) {
		this.root = linkedTree(vectArv, 1);
	}

	/**
	 * Metodo auxiliar usado para transformar a arvore sob a forma de vetor 
	 * numa arvore equivalente utilizando uma estrutura ligada de nos
	 * @param vectArv lista que representa a arvore sobre um vetor
	 * @param i valor inteiro
	 * @return arvore sob a forma de uma estrutura ligada de nos
	 */
	private TreeNode linkedTree(ArrayList<Pair<String, Float>> vectArv, int i){
		TreeNode arvore = new TreeNode(null, null, null);
		if(vectArv.size() != 0 && vectArv.get(1) == null){
			vectArv.remove(1);
		}
		if(i > vectArv.size()){
			return arvore;
		}
		if(arvore.data == null){
			arvore.data = vectArv.get(i);
		}
		if(2 * i >= vectArv.size()){
			return arvore;
		}else if(arvore.leftNode == null){
			arvore.leftNode = arvore;
		}
		arvore.leftNode = linkedTree(vectArv, 2 * i);

		if(2 * i + 1 >= vectArv.size()){
			return arvore;
		}else if(arvore.rightNode == null){
			arvore.rightNode = arvore;
		}
		arvore.rightNode = linkedTree(vectArv, 2 * i + 1);
		return arvore;
	}

	/**
	 * Metodo usado para obter a lista de todos os nomes de caracteristicas 
	 * (sem repeticoes) que a arvore de decisao usa nos seus nos internos
	 * @return lista com os nomes de caracteristicas
	 */
	public List<String> getFeatures() {
		ArrayList<String> features = new ArrayList<>();
		TreeNode arvore = this.root;
		return ehNohInterno(features, arvore, 1);
	}

	/**
	 * Metodo auxiliar usado para obter a lista de todos os nomes de 
	 * caracteristicas (sem repeticoes) que a arvore de decisao usa nos 
	 * seus nos internos
	 * @param features lista de caracteristicas
	 * @param arvore - arvore a ser percorrida
	 * @param i valor inteiro
	 * @return lista de todos os nomes de caracteristicas
	 */
	private List<String> ehNohInterno(ArrayList<String> features, TreeNode arvore, int i){
		if(arvore.leftNode == null && arvore.rightNode == null){
			return features;
		}
		if(arvore.data == null){
			return features;
		}
		if(!features.contains(arvore.data.first())){
			features.add(arvore.data.first());
		}
		else{
			while(2 * i < features.size()){
				if(arvore.leftNode != null){
					features = (ArrayList<String>) ehNohInterno(features, arvore.leftNode, 2 * i);
				}
			}while(2 * i + 1 < features.size()){
				if(arvore.rightNode != null){
					features = (ArrayList<String>) ehNohInterno(features, arvore.rightNode, 2 * i + 1);
				}
			}
		}

		return features;
	}

	/**
	 * Metodo usado para obter a lista de todas as decisoes (sem repeticoes) 
	 * que a arvore de decisao usa nos seus nos folha
	 * @return lista de todas as decisoes
	 */
	public List<String> getDecisions() {
		ArrayList<String> decisions = new ArrayList<>();
		TreeNode arvore = this.root;
		return ehFolha(decisions, arvore, 1);
	}

	/**
	 * Metodo auxiliar usado para obter a lista de todas as decisoes
	 * @param decisions lista de decisoes
	 * @param arvore - arvore a ser percorrida
	 * @param i valor inteiro
	 * @return lista de decisoes
	 */
	private List<String> ehFolha(ArrayList<String> decisions, TreeNode arvore, int i){
		//Se for folha
		if(arvore.leftNode == null && arvore.rightNode== null){
			if(!decisions.contains(arvore.data.first())){
				decisions.add(arvore.data.first());
			}
			//Se nao for folha
		}else{
			if(arvore.leftNode != null && arvore.leftNode.data == null){
				if(!decisions.contains(arvore.data.first())){
					decisions.add(arvore.data.first());
				}
			}else{//se nao tiver filhos
				decisions = (ArrayList<String>) ehFolha(decisions, arvore.leftNode, 2 * i);
			}
			if(arvore.rightNode != null && arvore.rightNode.data == null){
				if(!decisions.contains(arvore.data.first())){
					decisions.add(arvore.data.first());
				}
			}else{
				decisions = (ArrayList<String>) ehFolha(decisions, arvore.rightNode, 2 * i + 1);
			}
		}
		return decisions;
	}

	/**
	 * Metodo usado para obter o conjunto de regras
	 * @return conjunto de regras
	 */
	public String toRules() {
		return null;
	}

	/**
	 * Metodo usado para devolver a decisao obtida na situacao s1
	 * @param s1 situacao
	 * @return decisao da situacao s1
	 */
	public String decide(Situation s1) {
		/*TreeNode arvore = this.root;
		return decisao(s1, arvore, 1);*/
		return null;
	}
	
	/**
	 * Metodo auxilar para devolver a decisao consoante a situacao
	 * @param s1 situacao
	 * @param arvore - arvore
	 * @param i valor inteiro
	 * @return decisao da situacao s1
	 */
	/*private String decisao(Situation s1, TreeNode arvore, int i) {
		StringBuilder sb = new StringBuilder();
		Float sim = (float) 1;
		Float nao = (float) 0;
		//Se nao tiver filhos
		if(arvore.leftNode == null && arvore.rightNode == null){
			return null;
		}else{
			//Se o valor da caracteristica for sim, verifica leftNode
			if(sim.equals()){
				//se tiver um filho ah esquerda
				if(arvore.leftNode != null){
					decisao(s1, arvore.leftNode, 2 * i);
				//se tiver um filho ah direita
				}else if(arvore.rightNode != null){
					decisao(s1, arvore.rightNode, 2 * i + 1);
				//se nao tiver filhos
				}else{
					sb.append(arvore);
				}
			}
			//Se o valor da caracteristica for nao, verifica rightNode
			if(nao.equals()){
				//se tiver um filho ah esquerda
				if(arvore.leftNode != null){
					decisao(s1, arvore.leftNode, 2 * i);
				//se tiver um filho ah direita
				}else if(arvore.rightNode != null){
					decisao(s1, arvore.rightNode, 2 * i + 1);
				//se nao tiver filhos
				}else{
					sb.append(arvore);
				}
			}
		}
		return sb.toString();
	}*/


}