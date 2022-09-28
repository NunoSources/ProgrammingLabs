import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nuno Fontes n46413
 *
 */
public class Padroes {

    /**
     * Serah um valor com 4 algarismos obrigatoriamente
     * EX1 - multibancos
     * @param texto
     * @return
     */
    public int multibanco (String texto) {
    	Pattern pNumber = Pattern.compile("^\\d{4}$");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }

    /**
     * O numero de telefone comeca com +351 ou 00351 e tem obrigatoriamente 
     * exatamente mais 9 algarismos
     * EX2 - telefones tugas
     * @param texto
     * @return
     */
    public int telefonePorugues (String texto) {
    	Pattern pNumber = Pattern.compile("^([+]351|00351)\\d{9}$");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }

    /**
     * O numero de telemovel comeca em 91, 92, 93 ou 96 e tem obrigatoriamente 
     * exatamente mais 7 algarismos
     * EX3 - telemoveis tuga
     * @param texto
     * @return
     */
    public int telemoveisPortugueses (String texto) {
    	Pattern pNumber = Pattern.compile("^(91|92|93|96)\\d{7}$");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }


    /**
     * O nomes comecam sempre por letra maiscula, seguido de minusculas e 
     * estao separados por espacos
     * EX4 - nome com apelido
     * @param texto
     * @return
     */
    public int nomeComApelido (String texto) {
    	Pattern pNumber = Pattern.compile("^[A-Za-z]\\s[A-za-z]$");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }

    /**
     * O nome do ficheiro zip ou rar, comeca com um nome com letra minuscula, 
     * seguido de um ponto final e o nome da extensao, neste caso, rar ou zip
     * EX5 - ficheiro zip ou rar
     * @param texto
     * @return
     */
    public int ficheiroZipOuRar (String texto) {
    	Pattern pNumber = Pattern.compile("^[a-z][.](rar|zip)$");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }    


    /**
     * O nome de uma variavel Java comeca sempre por letra minuscula, 
     * podendo de seguida ser apresentada por letra maiscula, minuscula ou um numero
     * EX6 - variavel Java
     * @param texto
     * @return
     */
    public int variavelJava (String texto) {
    	Pattern pNumber = Pattern.compile("^[a-z]([A-za-z0-9])*");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }    

    /**
     * O nome de uma classe Java comeca por letra maiscula, podendo de seguida 
     * ser apresentada por letras maiusculas ou minusculas 
     * EX7 - classe Java
     * @param texto
     * @return
     */
    public int classeJava (String texto) {
    	Pattern pNumber = Pattern.compile("^[A-Z](A-Za-z)*");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }
    
    /**
     * Um comentario simples tem de comecar por 2 ou mais barras (//) 
     * EX8 - comentario simples java
     * @param texto
     * @return
     */
    public int comentarioSimplesJava (String texto) {
    	Pattern pNumber = Pattern.compile("^\\[A-Za-z0-9]*");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }

    /**
     * Os operadores aritmeticos Java sao o + % / * -
     * EX9 - operador aritmetico em java
     * @param texto
     * @return
     */
    public int operadorAritmeticoJava (String texto) {
    	Pattern pNumber = Pattern.compile("[+]|%|/|[*]|-|");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }

    /**
     * Os operadores logicos Java sao && e ||
     * EX10 - operador logico em java
     * @param texto
     * @return
     */
    public int operadorLogicoJava (String texto) {
    	Pattern pNumber = Pattern.compile("&&|(\\|\\|)");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }   


    /**
     * Um endereco IP tem de ser 4 valores separados por pontos finais
     * EX11 - endereco IP
     * @param texto
     * @return
     */
    public int enderecoIP (String texto) {
    	Pattern pNumber = Pattern.compile("\\d{1,}[.]\\d{1,}[.]\\d{1,}[.]\\d{1,}");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }   


    /**
     * A credencial de um aluno FCUL começa por fc seguido de 5 algarismos
     * EX12 - credencial aluno FCUL
     * @param texto
     * @return
     */
    public int credencialAlunoFcul (String texto) {
    	Pattern pNumber = Pattern.compile("fc\\d{5}");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }   

    /**
     * A data apresenta-se por 2 algarismos para o dia, 2 para o mes e 4 para o ano, 
     * separados por "-" (dd-mm-AAAA)
     * EX13 - data
     * @param texto
     * @return
     */
    public int data (String texto) {
    	Pattern pNumber = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }   


    /**
     * A matricula portuguesa apresenta se por 4 algarismos entre 0 e 9 
     * e 2 letras, separados por "-" do tipo (00-AA-00) 
     * EX14 - matricula portuguesa
     * @param texto
     * @return
     */
    public int matricula (String texto) {
    	Pattern pNumber = Pattern.compile("\\d{2}-([A-Z]r{2})-\\d{2}");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }   


    /**
     * EX15 - matricula portuguesa
     * @param texto
     * @return
     */
    public int euroOuDolar (String texto) {
    	Pattern pNumber = Pattern.compile("");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }   

    /**
     * O email tem de começar por uma ou mais letras, ter apenas um @ seguido de 
     * uma ou mais letras, um ponto final e "com" ou "pt"
     * EX16 - email
     * @param texto
     * @return
     */
    public int email (String texto) {
    	Pattern pNumber = Pattern.compile("^\\w{1,}@\\w{1,3}[.]\\w{1,3}$");
    	Matcher mNumber = pNumber.matcher(texto);
    	int n = 0;
    	
    	if(mNumber.find()){
    		n++;
    	}
    	
        return n;
    }   



}
