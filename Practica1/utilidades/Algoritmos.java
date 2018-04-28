package utilidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Algoritmos {
	private static int solucion = 0;

	public static void main(String[] args) {
		inicio();
	}

	public static void inicio() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("--------- Inicio del Programa -----------");

		System.out.println("\nIntroduzca el tamaño del lado del solar:");
		int tamSol = teclado.nextInt();

		int[] baldosas= Metodos.generarBaldosas(teclado);
		System.out.println("Tamaño del solar: " + tamSol + "m de lado, baldosas disponibles: ");
		for (int i = 0; i < baldosas.length; i++) {
			System.out.print(baldosas[i] + ", ");
		}
		System.out.println("");

		System.out.println("Algoritmo voraz: ");
		int[][] solVo = Metodos.generarSolar(tamSol);
		long tv0 = System.nanoTime();
		algVoraz(solVo, baldosas);
		long tv1 = System.nanoTime();
		Metodos.mostSolar(solVo);

		System.out.println("\n--------\nAlgoritmo backtracking: ");
		int[][] solBa = Metodos.generarSolar(tamSol);

		long tb0 = System.nanoTime();
		back ba=new back();
		ba.inicio(solBa, baldosas);
		long tb1 = System.nanoTime();

		System.out.println("  Voraz: " + (tv1 - tv0) + " ns	|  Backtracking: " + (tb1 - tb0) + " ns");
	}

	public static void algVoraz(int[][] solar, int[] baldosas) {
		int bal = baldosas.length;
		while (bal > 0) {
			int contbal = 0;
			int baldAct = baldosas[bal - 1];
			// Recorrer solar
			for (int i = 0; i < solar.length; i++) {
				for (int j = 0; j < solar.length; j++) {
					if ((solar[i][j] == 0) && (baldAct <= (solar.length - i)) && (baldAct <= (solar.length - j))) {
						if (Metodos.comprobarAdy(i, j, solar, baldAct)) {
							contbal = Metodos.rellenarBald(i, j, solar, baldAct, contbal);
						}
					}
				}
			}
			bal -= 1;
			System.out.println("El numero de baldosas utilizadas de tamaño " + baldAct + " es: " + contbal);
		}
	}

	public static void back(int solBa[][], int[][] solop, int[] balBa, int[] bald, int[] baldop, int[] coord) {
		int i;
		System.out.println(coord[0] + " " + coord[1] + "\n------------");
		if (Metodos.ultimaetapa(coord, solBa)) {
			System.out.println("ULTIMA ETAPA ");
			solucion++;
			/*
			 * if ((solucion == 1) || (solucion > 1 && Metodos.esMejor(bald, baldop))) {
			 * Metodos.asignar(solBa, solop, bald, baldop); }
			 */
			Metodos.mostSolar(solBa);
		} else {
			for (i = 0; i < balBa.length; i++) {
				System.out.println();
				Metodos.mostSolar(solBa);
				System.out.println(coord[0] + " " + coord[1] + "\n------------");
				if (Metodos.comprobarAdy(coord[0], coord[1], solBa, balBa[i], coord)) {
					Metodos.rellenarBald(coord[0], coord[1], solBa, balBa[i], bald[i]);
					back(solBa, solop, balBa, bald, baldop, coord);
					Metodos.borrar(coord[0], coord[1], solBa, balBa[i], bald[i]);
				}

			}
		}
	}

}
