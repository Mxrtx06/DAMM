package dado;

import java.util.Scanner;

public class Dado {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String[] dado = new String[6];
		dado[0] = "Reina";
		dado[1] = "Negro";
		dado[2] = "Rojo";
		dado[3] = "Jota";
		dado[4] = "Rey";
		dado[5] = "As";

		System.out.println("**DADO**");
		visualizarDado(dado);

		String[] tiradas = new String[5];
		System.out.println();
		System.out.println("--TIRADAS--");
		tiradas(tiradas, dado);
		visualizarTiradas(tiradas);

		int[] contador = new int[6];
		System.out.println();
		System.out.println("Veces se repite");
		contador(dado, tiradas, contador);

		System.out.println();
		System.out.println("Menu");
		System.out.println("Posibles resultados");
		System.out.println("5 iguales--REPOKER");
		System.out.println("4 iguales--POKER");
		System.out.println("3 iguales--TRIO");
		System.out.println("2 iguales--DOBLE");

		System.out.println();
		System.out.println("Resultados...");
		resultados(dado, contador);

	}

	private static void resultados(String[] dado, int[] contador) {

		for (int i = 0; i < dado.length; i++) {
				
				if(contador[i]>0) {
					if (contador[i] == 5) {
						System.out.println("REPOKER: Hay " + contador[i] + " " + dado[i]);
						
					} else if (contador[i] == 4) {
						System.out.println("POKER: Hay " + contador[i] + " " + dado[i]);
						
					} else if (contador[i] == 3) {
						System.out.println("TRIO: Hay " + contador[i] + " " + dado[i]);
						
					} else if(contador[i] == 2){
						System.out.println("DOBLES: Hay " + contador[i] + " " + dado[i]);
						
					
					}

			}

		
		}
	}

	private static void contador(String[] dado, String[] tiradas, int[] contador) {
		int cont = 0;
		for (int i = 0; i < dado.length; i++) {
			cont = 0;
			for (int j = 0; j < tiradas.length; j++) {
				if (dado[i] == tiradas[j]) {
					cont++;
				}
			}
			
				contador[i] = cont;
			

			System.out.println(dado[i] + " tiene " + contador[i] + " tiradas");
		}

	}

	private static void visualizarTiradas(String[] tiradas) {
		for (int i = 0; i < tiradas.length; i++) {
			System.out.println("Tirada " + i + " Valor: " + tiradas[i]);

		}

	}

	private static void tiradas(String[] tiradas, String[] dado) {
		int posicion = 0;
		for (int j = 0; j < tiradas.length; j++) {
			posicion = (int) (Math.random() * 5) + 1;
			tiradas[j] = dado[posicion];
		}

	}

	private static void visualizarDado(String[] dado) {
		for (int i = 0; i < dado.length; i++) {
			System.out.println("Cara " + i + " Valor: " + dado[i]);
		}

	}

}
