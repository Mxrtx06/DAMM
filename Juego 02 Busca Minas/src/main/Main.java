package main;

import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String tablero[][] = new String[10][10];

		rellenar(tablero);
		visualizar(tablero);
		System.out.println();
		rellenarMinas(tablero);
		visualizar(tablero);
	}

	private static void rellenarMinas(String[][] tablero) {
		int fila = 0;
		int columna = 0;
		boolean introducida = false;

		for (int a = 0; a < 15; a++) {
			introducida = false;
			do {
				fila = (int) (Math.random() * 9);
				columna = (int) (Math.random() * 9);

				if (!tablero[fila][columna].equals(" X ")) {//asegura q ya no hay una X
					tablero[fila][columna] = (" X ");
					introducida = true;
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

				System.out.print(tablero[i][j] + " ");
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

				tablero[i][j] = (" _ ");
			}
		}
	}
}
