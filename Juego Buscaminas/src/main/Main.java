package main;

import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String tablero[][] = new String[10][10];
		String[][] visibleTablero = new String[10][10];

		rellenar(tablero);
		rellenar(visibleTablero);
		rellenarMinas(tablero);
		contarMinas(tablero);
		visualizar(visibleTablero);
		preguntar(tablero,visibleTablero);
		
	}

	private static void preguntar(String[][] tablero, String[][] visibleTablero) {
		boolean perdido=false;
		do {
		int fila=0;
		do {
			System.out.println("Introduce fila= ");
			fila=in.nextInt();
			if(fila < 0 || fila >= tablero.length) {
				System.out.println("El numero se sobresale de los limites");
			}
		}while(fila < 0 || fila >= tablero.length);
		
		int columna=0;
		do {
			System.out.println("Introduce columna= ");
			columna=in.nextInt();
			if(columna < 0 || columna >= tablero[0].length) {
				System.out.println("El numero se sobresale de los limites");
			}
		}while(columna < 0 || columna >= tablero[0].length);
		
		if(tablero[fila][columna].equals("X")) {
			System.out.println("Vaya..., has perdido");
			visualizar(tablero);
			perdido=true;
		}
		else {
			visibleTablero[fila][columna] = tablero[fila][columna];
			visualizar(visibleTablero);
		}
		
		}while(!perdido);
	}

	private static void contarMinas(String[][] tablero) {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j].equals("_")) {


					int contador = 0;
					// derecha
					if (j < tablero[0].length - 1 && tablero[i][j + 1].equals("X")) {
						contador++;
					} else {
						tablero[i][j] = Integer.toString(0);
					}
					// izquierda
					if (j > 0 && tablero[i][j - 1].equals("X")) {
						contador++;
					} else {
						tablero[i][j] = Integer.toString(0);
					}
					// arriba
					if (i > 0 && tablero[i - 1][j].equals("X")) {
						contador++;
					} else {
						tablero[i][j] = Integer.toString(0);
					}
					// abajo
					if (i < tablero.length - 1 && tablero[i + 1][j].equals("X")) {
						contador++;
					} else {
						tablero[i][j] = Integer.toString(0);
					}
					// arriba derecha
					if (i > 0 && j < tablero[0].length - 1 && tablero[i - 1][j + 1].equals("X")) {
						contador++;
					} else {
						tablero[i][j] = Integer.toString(0);
					}
					// arriba izquierda
					if (i > 0 && j > 0 && tablero[i - 1][j - 1].equals("X")) {
						contador++;
					} else {
						tablero[i][j] = Integer.toString(0);
					}
					// abajo derecha
					if (i < tablero.length - 1 && j < tablero[0].length - 1 && tablero[i + 1][j + 1].equals("X")) {
						contador++;
					} else {
						tablero[i][j] = Integer.toString(0);
					}
					// abajo izquierda
					if (i < tablero.length - 1 && j > 0 && tablero[i + 1][j - 1].equals("X")) {
						contador++;
					} else {
						tablero[i][j] = Integer.toString(0);
					}
					tablero[i][j] = Integer.toString(contador++);
				}
			}

		}
	}

	private static void rellenarMinas(String[][] tablero) {
		int fila = 0;
		int columna = 0;
		boolean introducida = false;
		int minasColocadas=0;

		while (minasColocadas < 15) {
			introducida = false;
			do {
				fila = (int) (Math.random() * 9);
				columna = (int) (Math.random() * 9);

				if (!tablero[fila][columna].equals("X")) {// asegura q ya no hay una X
					tablero[fila][columna] = ("X");
					introducida = true;
					minasColocadas++;
				}

			} while (!introducida);

		}
	}

	private static void visualizar(String[][] tablero) {
		// arriba
		System.out.print("   ");
		for (int i = 0; i < tablero.length; i++) {
			System.out.print("  " + i + " ");
		}
		System.out.println();
		System.out.println("  --------------------------------------------");

		// izq
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(i + " | ");

			for (int j = 0; j < tablero[0].length; j++) {

				System.out.print(tablero[i][j] + "   ");
			}
			// derecha
			System.out.print(" | " + i);
			System.out.println();
		}

		// abajo
		System.out.println("  --------------------------------------------");
		System.out.print("   ");
		for (int i = 0; i < tablero.length; i++) {
			System.out.print("  " + i + " ");
		}
		System.out.println();

	}

	private static void rellenar(String[][] tablero) {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {

				tablero[i][j] = ("_");
			}
		}
	}
}
