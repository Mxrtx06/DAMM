package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String[] palabras = { "computadora", "programacion", "java", "desarrollador",
				"sistema", "tecnologia", "inteligencia" };

		String palabraAdivinar = palabras[(int) (Math.random() *7)];
		System.out.println(palabraAdivinar);

		String[] letras = palabraAdivinar.split("");
		String[] espacio = new String[palabraAdivinar.length()];

		
		for (int i = 0; i < espacio.length; i++) {
			espacio[i] = ("_ ");
			System.out.print(espacio[i]);
		}
		System.out.println();

		int intento = 10;
		boolean correcto=false;
		int posicion=0;
		
		do {
			System.out.println("Introduce q letra= ");
			String letra = in.nextLine();
			do {
				try {
					System.out.println("Introduce posicion= ");
					posicion = in.nextInt();
					in.nextLine();
					 if (posicion < 0 || posicion >= espacio.length) {
	                        System.out.println("Posición fuera de los límites, intenta nuevamente.");
	                    } else {
	                        correcto = true;
	                    }
				}catch(InputMismatchException e) {
					System.out.println("Debe ser un numero");
					in.nextLine();
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Sale de los limites");
					in.nextLine();
				}
			}while(!correcto || posicion < 0 || posicion >= espacio.length);
			

				if (letras[posicion].equals(letra)) {
					espacio[posicion] = letra;
					System.out.print("Corecto!!");
				} else {
					intento--;
					System.out.println("Incorrecto.");
				}
				
			System.out.println("Intentos restantes= " + intento);
			
			
			for(String solucion : espacio) {
				System.out.print(solucion+" ");
			}
			System.out.println();
			
			boolean adivinada=true;
			for (int i = 0; i < espacio.length; i++) {
				if(espacio[i].equals("_ ")) {
					adivinada=false;
					break;
				}
			}
			
			if(adivinada) {
				System.out.println("¡¡Palabra adivinada!!");
                break;
			}
			
			if (intento == 0) {
				System.out.println("Vaya, te quedastes sin oportunidades");
			}
		} while (intento > 0);
	}

}
