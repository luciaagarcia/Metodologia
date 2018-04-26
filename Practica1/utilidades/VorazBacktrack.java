package utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VorazBacktrack {

	public static void main(String[] args) {
		inicio();
	}

	public static void inicio() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("--------- Inicio del Programa -----------");

		System.out.println("\nIntroduzca el tamaño del lado del solar:");
		int tamSol = teclado.nextInt();
		int[][] solar = generarSolar(tamSol);

		ArrayList<Integer> baldosas = generarBaldosas(teclado);
		System.out.println("Tamaño del solar: " + tamSol + "m de lado, baldosas disponibles: ");
		for (int i = baldosas.size() - 1; i >= 0; i--)
			System.out.print(baldosas.get(i) + ", ");
		System.out.println("");

		System.out.println("Que algoritmo desea?\n1.Voraz \n2.Backtracking");
		int opt = teclado.nextInt();
		switch (opt) {
		case 1:
			Voraces.algVoraz(solar, baldosas);
			System.out.println("Usar ahora backtracking?: ");
			if(teclado.nextInt()==1) {
				//backtracking
			}
			break;
		case 2:
			
			break;
		}
		mostSolar(solar);
	}
	
	/*
	 * 
	 *-------------------------- Metodos comunes a los dos algoritmos ---------------------------
	 * 
	 */
	
	//----------------- Modificacion del solar ------------
	
	public static void rellenarBald(int ix, int jy, int[][] solar, int baldAct) {
		if (Back.comprobarAdy(ix, jy, solar, baldAct)) {
			for (int i = ix; i <= baldAct + ix - 1; i++) {
				for (int j = jy; j <= baldAct + jy - 1; j++) {
					solar[i][j] = baldAct;
				}
			}
		}
	}
	
	public static int rellenarBald(int ix, int jy, int[][] solar, int baldAct, int contbal) {
		if (Voraces.comprobarAdy(ix, jy, solar, baldAct)) {
			for (int i = ix; i <= baldAct + ix - 1; i++) {
				for (int j = jy; j <= baldAct + jy - 1; j++) {
					solar[i][j] = baldAct;
				}
			}
			contbal = contbal + 1;
		}
		return contbal;
	}
	
	
	
	//----------------- Generacion y muestra --------------
	public static ArrayList<Integer> generarAut(Scanner teclado) {
		System.out.print("Introduzca tamaño de la baldosa mas grande: ");
		int tamMax = teclado.nextInt();
		ArrayList<Integer> bald = new ArrayList<Integer>();
		for (int i = 1; i <= tamMax; i++) {
			bald.add(i);
		}
		return bald;
	}

	public static ArrayList<Integer> generarMan(Scanner teclado) {
		System.out.print("Cuantas baldosas quiere poner: ");
		int Max = teclado.nextInt();
		ArrayList<Integer> bald = new ArrayList<Integer>();
		for (int i = 0; i < Max; i++) {
			System.out.println("Baldosa " + i);
			bald.add(teclado.nextInt());
		}
		Collections.sort(bald);
		return bald;
	}
	
	public static void mostSolar(int[][] solar) {
		for (int i = 0; i < solar.length; i++) {
			for (int j = 0; j < solar.length; j++) {
				System.out.print(solar[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] generarSolar(int tamSol) {
		int[][] solar = new int[tamSol][tamSol];
		for (int i = 0; i < solar.length; i++) {
			for (int j = 0; j < solar.length; j++) {
				solar[i][j] = 0;
			}
		}
		return solar;
	}

	public static ArrayList<Integer> generarBaldosas(Scanner teclado) {
		System.out.println("\nOpciones para generar baldosas:");
		System.out.println("1.Generar baldosas hasta un tamaño");
		System.out.println("2.Introducir tamaños manualmente");
		ArrayList<Integer> bald = null;
		int opt = teclado.nextInt();
		switch (opt) {
		case 1:
			bald = generarAut(teclado);
			break;
		case 2:
			bald = generarMan(teclado);
			break;
		default:
			System.out.println("Opcion introducida incorrecta");
		}
		return bald;

	}

}
