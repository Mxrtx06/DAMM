package main;

import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String[][] tablero = new String[3][3];

		rellenar(tablero);
		visualizar(tablero);
		rellenarDatos(tablero);

	}

	private static void rellenarDatos(String[][] tablero) {
		int fila = 0;
		int columna = 0;
		boolean ganado = false;
		int cont = 0;

		do {
			// USUARIO
			do {
				// fila no vale num
				do {
					System.out.println("Fila que quieres rellenar:");
					fila = in.nextInt();
					if (fila >= tablero.length || fila < 0) {
						System.out.println("Fila no vaida");
					}
				} while ((fila >= tablero.length) || (fila < 0));
				// columna no vale num
				do {
					System.out.println("Columna que quieres rellenar:");
					columna = in.nextInt();

					if (columna >= tablero.length || columna < 0) {
						System.out.println("Columna no vaida");
					}
				} while ((columna >= tablero.length) || (columna < 0));

				// comprobar si ya esta escrita
				if (tablero[fila][columna].equals("[X]") || tablero[fila][columna].equals("[O]")) {
					System.out.println("Este puesto ya esta ocupado");
				} else {
					tablero[fila][columna] = ("[X]");
					cont++;
					break;
				}

			} while (tablero[fila][columna].equals("[X]") || tablero[fila][columna].equals("[O]"));

			visualizar(tablero);

			// solucion
			int contJ = 0;
			// columnas tiene x
			for (int i = 0; i < tablero.length; i++) {
				contJ = 0;
				for (int j = 0; j < tablero[0].length; j++) {
					if (tablero[i][j].equals("[X]")) {
						contJ++;
					}
				}
				if (contJ == 3)
					break;
			}
			int contI = 0;
			// filas tiene x
			for (int j = 0; j < tablero[0].length; j++) {
				contI = 0;
				for (int i = 0; i < tablero.length; i++) {
					if (tablero[i][j].equals("[X]")) {
						contI++;
					}
				}
				if (contI == 3)
					break;
			}
			if (contJ == 3 || contI == 3
					|| (tablero[1][1].equals("[X]") && tablero[0][0].equals("[X]") && tablero[2][2].equals("[X]"))
					|| (tablero[1][1].equals("[X]") && tablero[0][2].equals("[X]") && tablero[2][0].equals("[X]"))) {

				System.out.println("¡¡HAS GANADO!!");
				ganado = true;
				break;
			}
			System.out.println();

			if (cont == 9 && !ganado) {
				System.out.println("Empate");
				break;
			}

			// MAQUINA

			int filaMaq = 0;
			int columnaMaq = 0;

			do {
				filaMaq = (int) (Math.random() * 3) + 0;
				columnaMaq = (int) (Math.random() * 3) + 0;
			} while (tablero[filaMaq][columnaMaq].equals("[X]") || tablero[filaMaq][columnaMaq].equals("[O]"));

			tablero[filaMaq][columnaMaq] = ("[O]");
			cont++;

			visualizar(tablero);

			// RESULTADO

			// columna
			int contMJ = 0;
			for (int i = 0; i < tablero.length; i++) {
				contMJ = 0;
				for (int j = 0; j < tablero[0].length; j++) {
					if (tablero[i][j].equals("[O]")) {
						contMJ++;
					}
				}
				if (contMJ == 3)
					break;
			}
			// fila
			int contMI = 0;
			for (int j = 0; j < tablero[0].length; j++) {
				contMI = 0;
				for (int i = 0; i < tablero.length; i++) {
					if (tablero[i][j].equals("[O]")) {
						contMI++;
					}
				}
				if (contMI == 3)
					break;
			}
			if (contMJ == 3 || contMI == 3
					|| (tablero[1][1].equals("[O]") && tablero[0][0].equals("[O]") && tablero[2][2].equals("[O]"))
					|| (tablero[1][1].equals("[O]") && tablero[0][2].equals("[O]") && tablero[2][0].equals("[O]"))) {
				System.out.println("Has perdido...");
				ganado = true;
				break;
			}

			// EMPATE

		} while (cont < 9 && !ganado);

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
				tablero[i][j] = "[ ]";
			}
			
		}

	}

}
