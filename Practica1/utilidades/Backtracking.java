package utilidades;

public class Backtracking {
	
	public static void main(String [] args){
		String [] original= {"4","8","1"};
		int N=; //Longitud de un lado
		String[] estado=new String[N];
		VCRmn(estado, original, 0);
		}

	public static void backtrack(int[][] solar, int[][] solarSol, int[] vecBal, int[] etapa) {
		int baldAct = vecBal[0];
		for (int i = 0; i < solar.length; i++) {
			for (int j = 0; j < solar.length; j++) {
				// Comprobar que el hueco sea mayor o igual que el tamaño de la baldosa
				if ((solar[i][j] == 0) && (baldAct <= (solar.length - i)) && (baldAct <= (solar.length - j))) {
					// Comprobar que ese hueco este vacio
					if (comprobarAdy(i, j, solar, baldAct)) {
						rellenarBald(i, j, solar, baldAct);

					}
				}
			}
		}
	}

	public static boolean comprobarAdy(int ix, int jy, int[][] solar, int baldAct) {
		boolean vacio = true;
		for (int i = ix; i <= baldAct + ix - 1; i++) {
			for (int j = jy; j <= baldAct + jy - 1; j++) {
				if (solar[i][j] != 0) {
					vacio = false;
				}
			}
		}
		return vacio;
	}

	public static void rellenarBald(int ix, int jy, int[][] solar, int baldAct) {
		if (comprobarAdy(ix, jy, solar, baldAct)) {
			for (int i = ix; i <= baldAct + ix - 1; i++) {
				for (int j = jy; j <= baldAct + jy - 1; j++) {
					solar[i][j] = baldAct;
				}
			}
		}
	}

	public static void VCRmn(String[] actual, String[] original, int etapa) {
		if (etapa == actual.length) {
			for (int i = 0; i < actual.length; i++) { //Esto solo es para imprimir cuando haya llegado a una solucion AHHH va va va ya lo voy pillaaando
				System.out.print(actual[i] + " ");
			}
			System.out.println();
		} else {
			for (int k = 0; k < original.length; k++) {
				actual[etapa] = original[k];
				VCRmn(actual, original, etapa + 1);
			}
		}
	}
}
