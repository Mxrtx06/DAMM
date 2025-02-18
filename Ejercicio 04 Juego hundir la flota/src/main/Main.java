package main;

import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String tablero[][] = new String[6][6];
		rellenar(tablero);
		visualizar(tablero);
		System.out.println("**Barcos escondidos**");
		int[][] barcos = posicionBarcos(tablero);
		System.out.println();

		tiradas(tablero, barcos);

	}

	private static void tiradas(String[][] tablero, int[][] barcos) {
		int encontrado = 0;
		boolean iguales = false;
		boolean repetido = false;
		int intentos = 0;
		int fila = 0;
		int columna = 0;
		do {
			do {
				System.out.println("Introduce datos:");

				do {
					System.out.println("Fila= ");
					fila = in.nextInt();
					if (fila < 1 || fila > tablero.length - 1) {
						System.out.println("Fila no se encuentra, intentelo de nuevo");
					}
				} while (fila < 1 || fila > tablero.length - 1);

				do {
					System.out.println("Columna= ");
					columna = in.nextInt();
					if (columna < 1 || columna > tablero.length - 1) {
						System.out.println("Columna no se encuentra, intentelo de nuevo");
					}
				} while (columna < 1 || columna > tablero.length - 1);

				repetido = false;
				if (tablero[fila][columna] == "[X] " || tablero[fila][columna] == "[0] ") {
					System.out.println("Numero ya ha sido introducirdo");
					repetido = true;
				}

			} while (repetido);
			intentos++;
			iguales = false;
			for (int i = 0; i < barcos.length; i++) {
				if (fila == barcos[i][0] && columna == barcos[i][1]) {
					System.out.println("¡¡¡BARCO ENCONTRADO!!");
					iguales = true;
					encontrado++;
					tablero[fila][columna] = "[X] ";
					visualizar(tablero);
					break;
				}
			}
			if (!iguales) {
				System.out.println("Agua,Intentelo otra vez");
				tablero[fila][columna] = "[0] ";
				visualizar(tablero);
			}
			System.out.println("Has erealizado " + intentos + " intento/s");
		} while (encontrado < 3);

	}

	private static int[][] posicionBarcos(String[][] tablero) {
		boolean introducida = false;
		int filaSolucion = 0;
		int columnaSolucion = 0;
		int barcos[][] = new int[3][2];
		
		for (int i = 0; i < barcos.length; i++) {
			introducida = false;
			while (!introducida) {
				filaSolucion = (int) (Math.random() * tablero.length - 1) + 1;
				columnaSolucion = (int) (Math.random() * tablero[0].length - 1) + 1;

				introducida=true;
				
				for (int j = 0; j < barcos[0].length; j++) {
					if (barcos[j][0] == filaSolucion && barcos[j][1] == columnaSolucion) {
						introducida = true;
						break;
					}
				}

			}
			barcos[i][0] = filaSolucion;
			barcos[i][1] = columnaSolucion;
			System.out.println(
					"Barco " + (i + 1) + " Posicion " + "[" + filaSolucion + "]" + "[" + columnaSolucion + "]");
		}

		return barcos;
	}

	private static void visualizar(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				System.out.print(tablero[i][j] + " ");

			}
			System.out.println();
		}
	}

	private static void rellenar(String[][] tablero) {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (i == 0 && j == 0) {
					tablero[i][j] = "    ";

				} 
				else if (i == 0) {
					tablero[i][j] = (" " + j + "  ");
				}

				else if (j == 0) {
					tablero[i][j] = (" " + i + "  ");

				}

				else {
					tablero[i][j] = ("[ ] ");
				}

			}

		}

	}

}
