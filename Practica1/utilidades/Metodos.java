package utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Metodos {
	// ------------ Modificacion del solar -----------------

	public static int rellenarBald(int ix, int jy, int[][] solar, int baldAct, int contbal) {
		for (int i = ix; i <= baldAct + ix - 1; i++) {
			for (int j = jy; j <= baldAct + jy - 1; j++) {
				solar[i][j] = baldAct;
			}
		}
		contbal = contbal + 1;
		return contbal;
	}

	public static int borrar(int ix, int jy, int[][] solar, int baldAct, int contbal) {
		for (int i = ix; i <= baldAct + ix - 1; i++) {
			for (int j = jy; j <= baldAct + jy - 1; j++) {
				solar[i][j] = 0;
			}
		}
		contbal = contbal - 1;
		return contbal;
	}

	public static boolean comprobarAdy(int ix, int jy, int[][] solar, int baldAct) {
		boolean vacio = true;
		for (int i = ix; i < baldAct + ix; i++) {
			for (int j = jy; j < baldAct + jy; j++) {
				if (solar[i][j] != 0) {
					vacio = false;
				}
			}
		}
		return vacio;
	}

	public static boolean comprobarAdy(int ix, int jy, int[][] solar, int baldAct, int[] coord) {
		boolean cabe = false, parar = false;

		for (int i = 0; i < solar.length && !parar; i++) {
			for (int j = 0; j < solar.length && !parar; j++) {
				if ((solar[i][j] == 0) && ((solar.length - j) >= baldAct) && ((solar.length - i) >= baldAct)) {
					for (int a = i; a <= (baldAct + i) - 1; a++) {
						for (int b = j; b <= (baldAct + j) - 1; b++) {
							if (solar[a][b] != 0) {
								a = baldAct + i + 1;
								b = baldAct + j + 1;
								cabe = false;
							} else {
								cabe = true;
								coord[0] = i;
								coord[1] = j;
								parar = true;
							}
						}

					}
				}
			}

		}
		return cabe;
	}

	public static boolean comprobarAdyBorrar(int ix, int jy, int[][] solar, int baldAct, int[] coord) {
		boolean cabe = false, parar = false;

		for (int i = solar.length - 1; i <= 0 && !parar; i--) {
			for (int j = solar.length - 1; j < 0 && !parar; j--) {
				if (solar[i][j] == baldAct && (solar.length - j) >= baldAct && (solar.length - i) >= baldAct) {
					for (int a = i; a <= (baldAct + i) - 1; a++) {
						for (int b = j; b <= (baldAct + j) - 1; b++) {
							if (solar[a][b] != 0) {
								a = baldAct + i + 1;
								b = baldAct + j + 1;
								cabe = false;
							} else {
								cabe = true;
								coord[0] = i;
								coord[1] = j;
								parar = true;
							}
						}

					}
				}
			}

		}
		return cabe;
	}

	// ------------ Metodos relacionados con el solar ------------

	public static boolean ultimaetapa(int[] coord, int[][] solar) {
		boolean ultima = true;
		for (int i = 0; i < solar.length; i++) {
			for (int j = 0; j < solar.length; j++) {
				if (solar[i][j] == 0) {
					ultima = false;
					i = j = solar.length;
				}
			}
		}

		return ultima;
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

	public static void mostSolar(int[][] solar) {
		for (int i = 0; i < solar.length; i++) {
			for (int j = 0; j < solar.length; j++) {
				System.out.print(solar[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void asignar(int[][] solar, int[][] solop, int[] bald, int[] baldop) {
		for (int i = 0; i < solar.length; i++) {
			for (int j = 0; j < solar.length; j++) {
				solar[i][j] = solop[i][j];
			}
		}
		for (int i = 0; i < bald.length; i++) {
			bald[i] = baldop[i];
		}

	}

	// ----------- Metodos relacionados con las baldosas -----------

	public static boolean esMejor(int[] bald, int[] baldop) {
		boolean mejor = false;
		for (int i = 0; i < bald.length; i++) {
			if (baldop[i] < bald[i]) {
				mejor = true;
			}
		}
		return mejor;
	}

	public static int[] generarBaldosas(Scanner teclado) {
		System.out.println("\nOpciones para generar baldosas:");
		System.out.println("1.Generar baldosas hasta un tamaño");
		System.out.println("2.Introducir tamaños manualmente");
		int[] bald = null;
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

	public static int[] generarAut(Scanner teclado) {
		System.out.print("Introduzca tamaño de la baldosa mas grande: ");
		int tamMax = teclado.nextInt();
		int[] bald = new int[tamMax];
		for (int i = 1; i <= tamMax; i++) {
			bald[i - 1] = i;
		}
		return bald;
	}

	public static int[] generarMan(Scanner teclado) {
		System.out.print("Cuantas baldosas quiere poner: ");
		int Max = teclado.nextInt();
		int[] bald = new int[Max];
		System.out.println("(Introduzca el tamaño de las baldosas de menor a mayor)");
		for (int i = 0; i < bald.length; i++) {
			System.out.println("Baldosa " + i);
			bald[i] = (teclado.nextInt());
		}

		// Collections.sort(bald);
		return bald;
	}

}
