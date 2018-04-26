package utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Voraces {

	public static void algVoraz(int[][] solar, ArrayList<Integer> baldosas) {
		while (!baldosas.isEmpty()) {
			int contbal = 0;
			int baldAct = baldosas.get(baldosas.size() - 1);
			// Recorrer solar
			for (int i = 0; i < solar.length; i++) {
				for (int j = 0; j < solar.length; j++) {
					if ((solar[i][j] == 0) && (baldAct <= (solar.length - i)) && (baldAct <= (solar.length - j))) {
						contbal=VorazBacktrack.rellenarBald(i, j, solar, baldAct, contbal);
					}
				}
			}
			baldosas.remove(baldosas.size() - 1);
			System.out.println("El numero de baldosas utilizadas de tamaño " + baldAct + " es: " + contbal);
		}
	}



	public static boolean comprobarAdy(int ix, int jy, int[][] solar, int baldAct) {
		boolean vacio = true;
		for (int i = ix; i < baldAct + ix ; i++) {
			for (int j = jy; j < baldAct + jy ; j++) {
				if (solar[i][j] != 0) {
					vacio = false;
				}
			}
		}
		return vacio;
	}

	
	
}
