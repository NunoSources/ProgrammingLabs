

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Profs LabP
 *
 */
public class RunDecisionTree {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader inArv = new BufferedReader(new FileReader("resources/arvore.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter("resources/resultado.txt"));

        ArrayList<Pair<String, Float>> vectArv = 
        		new ArrayList<Pair<String, Float>>();
        vectArv.add(null);  // valor null no indice 0

        buildTreeVector(vectArv, inArv);
        inArv.close();

        LinkedDecisionTree arv = new LinkedDecisionTree(vectArv);
                
        out.write("Caracteristicas usadas na arvore: \n\n" + 
                   arv.getFeatures() + "\n\n");
        
        out.write("Decisoes usadas na arvore: \n\n" + arv.getDecisions() 
        		  + "\n\n");

        out.write("Conjunto de regras na arvore: \n\n" + arv.toRules() 
        		  + "\n\n");

        BufferedReader inSit1
                = new BufferedReader(new FileReader("resources/situacao1.txt"));

        HashMap<String, Float> sit1Map = loadSituation(inSit1);
        inSit1.close();
        Situation s1 = new Situation(sit1Map);

        if (arv.decide(s1)!= null) {
            out.write("Decisao para a primeira situacao: \n" + arv.decide(s1) 
            		+ ".\n\n");
        } else {
            out.write("Primeira situacao nao pode ser decidida " + 
            		"pela arvore. \n");
        }

        BufferedReader inSit2
                = new BufferedReader(new FileReader("resources/situacao2.txt"));

        HashMap<String, Float> mapSit2 = loadSituation(inSit2);
        inSit2.close();
        Situation s2 = new Situation(mapSit2);

        if (arv.decide(s2)!= null) {
            out.write("Decisao para a segunda situacao: \n" + arv.decide(s2) 
            		+ ".\n\n");
        } else {
            out.write("Segunda situacao nao pode ser decidida pela arvore. \n");
        }

        out.close();

    }

    private static void buildTreeVector(ArrayList<Pair<String, Float>> v, 
    		BufferedReader file) throws IOException {
        int numNodes = Integer.parseInt(file.readLine());
        for (int i = 1; i <= numNodes; i++) {
            String linha = file.readLine();
            if (linha.length() == 0) { // no inexistente
                v.add(i, null);
            } else {
                int posVirg = linha.indexOf(',');
                String s;
                Float x = null;
                if (posVirg == -1) {
                	// linha nao contem virgula: teste booleano ou decisao
                    s = linha;
                } else {
                    s = linha.substring(0, posVirg);
                    x = Float.parseFloat(linha.substring(posVirg + 1, linha.length()));
                }

                Pair<String, Float> p = new Pair<String, Float>(s, x);
                v.add(i, p);
            }
        }
    }

    private static HashMap<String,Float> loadSituation(BufferedReader file) 
    		throws IOException {
        HashMap<String, Float> map = new HashMap<>();
        int numFeatures = Integer.parseInt(file.readLine());
        for (int i = 0; i < numFeatures; i++) {
            String linha = file.readLine();
            int posVirg = linha.indexOf(',');
            String s, s1;
            Float x;
            s = linha.substring(0, posVirg);
            s1 = linha.substring(posVirg + 1, linha.length());
            if (s1.contains("sim")) {
                x = (float) 1;
            } else if (s1.contains("nao")) {
                x = (float) 0;
            } else {
                x = Float.parseFloat(s1);
            }
            map.put(s, x);
        }
        return map;
    }

}
