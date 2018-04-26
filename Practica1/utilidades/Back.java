package utilidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Back {
	/*
	 * Variables: solar: El solar original solop: Copia auxiliar del solar para
	 * comparar con el original y saber si existe una mejor solucion baldosas: Array
	 * que contiene los tamaños disponibles de baldosas bald: Baldosas usadas para
	 * completar el solar baldop: Copia auxiliar de las baldosas usadas para
	 * comparar con la original y saber si existe una mejor solucion.
	 * 
	 */

	public static void inicio(int[][] solar,ArrayList<Integer> baldosas ) {


		int[] bald = new int[baldosas.size()];
		int[] baldop = new int[baldosas.size()];
		int[][] solop = solar.clone();
		back(solar, solop, baldosas, bald, baldop);
		
	}

	public static void back(int solar[][], int[][] solop, ArrayList<Integer> baldosas, int[] bald, int[] baldop) {
		int i;
		int[] coord = new int[2];
		if (solucion(solar, baldosas)) {
			if ((libre(solar)) && contadorbaldosas(bald) < contadorbaldosas(baldop) || contadorbaldosas(baldop) == 0) {

				VorazBacktrack.mostSolar(solar);
				System.out.println(
						"El numero de baldosas utilizadas es: " + contadorbaldosas(bald) + "\n-----------------");
				solop = solar.clone();
				
				System.arraycopy(bald, 0, baldop, 0, bald.length);
			}
			// mostSolar(sol);
		}

		else {
			for (i = 0; i < baldosas.size(); i++) {
				if (posible(solar, baldosas.get(i), coord)) {
					VorazBacktrack.rellenarBald(coord[0],coord[1],solar, baldosas.get(i));
					bald[i]++;
					back(solar, solop, baldosas, bald, baldop);
					borrar( coord[0], coord[1],solar, baldosas.get(i));
					bald[i]--;
				}
			}
		}
	}

	public static boolean solucion(int solar[][], ArrayList<Integer> baldosas) {
		boolean complete = true;
		for (int i = 0; i < solar.length && complete; i++) {
			for (int j = 0; j < solar[i].length && complete; j++) {
				if (solar[i][j] == 0) {
					// Este for lo que hace es volver a comprobar si hay huecos con el tamaño de
					// baldosa que disponemos
					for (int k = 0; k < baldosas.size() && complete; k++) {
						if (comprobarAdy(i,j,solar, baldosas.get(k))) {
							complete = false;
						}
					}
				}
			}
		}
		return complete;
	}

	public static boolean libre(int[][] sol) {
		int contador = 0;
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[i].length; j++) {
				if (sol[i][j] == 0) {
					contador++;
				}
			}
		}
		return (contador == 0);
	}

	public static int contadorbaldosas(int matriz[]) {
		int amount = 0;
		for (int i = 0; i < matriz.length; i++) {
			amount += matriz[i];
		}
		return amount;
	}

	public static void copiar(int[][] sol, int[][] solop) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[i].length; j++) {
				solop[i][j] = sol[i][j];
			}
		}
	}

	public static boolean posible(int solar[][], int baldAct, int cell[]) {
		boolean found = false;
		for (int i = 0; i < solar.length && !found; i++) {
			for (int j = 0; j < solar[i].length && !found; j++) {
				if (solar[i][j] == 0) {
					if (comprobarAdy(i,j,solar, baldAct)) {
						found = true;
						cell[0] = i;
						cell[1] = j;
					}
				}
			}
		}
		return found;
	}

	public static boolean comprobarAdy(int x, int y, int [][] solar, int baldAct) {
		int contadorx = 0;
		int contadory = 0;
		int i = x, j = y;
		boolean vacio = false;
		boolean limite = false;

		while (i < solar.length && !limite) {
			if (solar[i++][y] != 0)
				limite = true;
			else
				contadorx++;
		}

		while (j < solar[x].length && !limite) {
			if (solar[x][j++] != 0)
				limite = true;
			else
				contadory++;

		}
		if (contadorx >= baldAct && contadory >= baldAct)
			vacio = true;

		return vacio;
	}

	public static void borrar(int y, int x, int [][] solar, int baldAct) {
		for (int i = x; i < x + baldAct; i++)
			for (int j = y; j < y + baldAct; j++)
				solar[i][j] = 0;
	}

}
