
/**
 * @author Nuno Fontes, n 46413
 *
 */

public class calculadora {

	final double pi = 3.14; //o valor do numero Pi
	private int NumeroDeCalculos;
	public static final int NUMBER = 2;

	public boolean Ehpar (int valor) {
		this.NumeroDeCalculos++;
		if (valor % NUMBER == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	//vou precisar de mudar o PI?
	public void setPi(int QUANTASCASAS) {
		throw new UnsupportedOperationException();
	}

	public double NumeroPi() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numeroCalculos() {
		return NumeroDeCalculos;
	}

	public int dobro (int valor) {
		this.NumeroDeCalculos++;
		int v = NUMBER * valor;
		return v;
	}

	public static void EhPotenciaDe10 (int[] potencias, int valor) {
		int power10 = 1;
		for (int i = 0; i < potencias.length; i++) {
			if(power10 == valor){
				potencias[i]++;
			}
			else{

				power10 *= potencias.length;
			}
			System.out.println("Linha para controlo do que eh executado. "
					+ "Encontrei um problema neste metodo que nao faz o que eh suposto fazer!");
		}
	}

}