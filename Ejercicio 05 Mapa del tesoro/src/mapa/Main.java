package mapa;

public class Main {

	public static void main(String[] args) {
		int[][] mapa = new int[4][4];
		System.out.println("**MAPA**");
		rellenar(mapa);
		visualizar(mapa);
		System.out.println();
		System.out.println("**MAPA CON ORO**");
		oro(mapa);

	}

	private static void oro(int[][] mapa) {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
					int Actual = mapa[i][j];
					int ValorDerecha=0;
					int ValorIzq=0;
					int ValorArriba=0;
					int ValorAbajo=0;
					int ValorArribaDerecha=0;
					int ValorArribaIzquierda=0;
					int ValorAbajoDerecha=0;
					int ValorAbajoIzquierda=0;
					
					int contador=0;
					//derecha
					if(j<mapa[0].length-1) {
						ValorDerecha = (mapa[i][j + 1]);
						contador++;
					}
					//izquierda
					if (j>0){
						ValorIzq = (mapa[i][j - 1]);
						contador++;
					}
					//arriba
					if(i > 0) {
						ValorArriba = (mapa[i - 1][j]);
						contador++;
					}
					//abajo
					if(i<mapa.length-1) {
						ValorAbajo = (mapa[i + 1][j]);
						contador++;
					}
					// arriba derecha
					if(i > 0 && j<mapa[0].length-1) {
						ValorArribaDerecha = (mapa[i - 1][j + 1]);
						contador++;
					}
					//arriba izquierda
					if(i > 0 && j>0){
						ValorArribaIzquierda = (mapa[i - 1][j - 1]);
						contador++;
					}
					//abajo derecha
					if(i<mapa.length-1 && j<mapa[0].length-1) {
						ValorAbajoDerecha = (mapa[i + 1][j + 1]);
						contador++;
					}
					//abajo izquierda
					if(i<mapa.length-1 && j>0 ){
						ValorAbajoIzquierda = (mapa[i + 1][j - 1]);
						contador++;
					}
					
					
					int suma=ValorDerecha + ValorIzq + ValorAbajo + ValorArriba + ValorAbajoDerecha + ValorAbajoIzquierda + ValorArribaDerecha + ValorArribaIzquierda;
					int promedio = suma / contador;
					
					if (Actual > promedio) {
						System.out.print(" * ");
					}
					else {
						System.out.print(mapa[i][j]+" ");
					}
					
			}
			System.out.println();
		}
		
	}

	private static void visualizar(int[][] mapa) {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				System.out.print(mapa[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void rellenar(int[][] mapa) {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[0].length; j++) {
				mapa[i][j] = (int) ((Math.random() * 90) + 1);
			}
		}
	}
}
