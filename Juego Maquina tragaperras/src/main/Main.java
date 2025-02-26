package main;

import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int moneda = 4;
		String[] figuras = new String[5];
		figuras[0] = "Corazon";
		figuras[1] = "Diamante";
		figuras[2] = "Herradura";
		figuras[3] = "Campana";
		figuras[4] = "Limón";

		System.out.println("Bienvenido a la máquina tragaperras");
		System.out.println("Si consigue 2 figuras iguales le devolvemos su dinero");
		System.out.println("Si consigue las 3, habrá ganado el premio");
		System.out.println("¡Buena suerte!");

		do {
			String tiradas[] = new String[3];
			tiradas[0] = figuras[(int) (Math.random() * 5)];
			tiradas[1] = figuras[(int) (Math.random() * 5)];
			tiradas[2] = figuras[(int) (Math.random() * 5)];

			System.out.println("--------------------------------");
			System.out.println("|" + tiradas[0] + "|" + tiradas[1] + "|" + tiradas[2] + "|");
			System.out.println("--------------------------------");

			if (tiradas[0].equals(tiradas[1]) && tiradas[0].equals(tiradas[2])) {
				System.out.println("Enhorabuena, ha ganado el premio!, aqui tiene sus 10 monedas");
				moneda = moneda + 10;
			} else if (tiradas[0].equals(tiradas[1]) && !tiradas[0].equals(tiradas[2])
					|| tiradas[0].equals(tiradas[2]) && !tiradas[0].equals(tiradas[1])
					|| tiradas[1].equals(tiradas[2]) && !tiradas[0].equals(tiradas[2])) {
				System.out.println(
						"¡Uy!, ha estado a punto, aquí tiene su moneda de nuevo. En la siguiente tirada tendrá más suerte");
				moneda++;
			} else {
				System.out.println("Vaya... ha perdido, no se desanime, a la siguiente tendrá más suerte...");
				moneda--;
			}

			System.out.println("Cantidad de monedas= " + moneda);

			if (moneda == 0) {
				System.out.println("Vaya, te quedastes sin monedas...");
			}

		} while (moneda > 0);

	}

}
