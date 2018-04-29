package utilidades;

public class back {
	int [][] solar;
	int contSol=0;
	public void inicio(int [][] solar, int [] baldosas) {
		int [] baldUs= new int [baldosas.length];
		int[] baldMejor = new int[baldosas.length];
		for(int i=0; i<baldMejor.length;i++)baldMejor[i]=999;
		int[][] solMejor = Metodos.generarSolar(solar.length);
		backtraking(solar, solMejor, baldosas, baldUs,baldMejor);
		if(contSol==0) {
			System.out.println("No se ha encontrado una solucion");
		}else{
			System.out.println("Esta es la mejor opcion de un total de "+contSol+" soluciones:");
			mostSolar(solMejor);
		}
	}

	public void backtraking(int[][] solar, int [][] solMejor, int[] baldosas, int []baldUs, int[] baldMejor) {
		int posicion[] = new int[2];

		// Caso base. Si lo ha completado, lo muestra

		if (completado(solar)) {
			contSol++;
			if ((contSol > 0 &&(numBald(baldUs) < numBald(baldMejor)))) {//Hay que arreglar esto hulia, pero creo que ya lo tengo
				System.out.println("Reduciendo de "+numBald(baldMejor)+ " a "+numBald(baldUs) +" baldosas");
				cambSolar(solar, solMejor, baldUs, baldMejor);
			}

		}

		else {

			for (int i = 0; i < baldosas.length; i++) {
				if (cabeBack(i, posicion, baldosas, solar)) {
					ponerBack(posicion[0], posicion[1], i, baldosas, solar, baldUs);
					backtraking(solar, solMejor, baldosas, baldUs, baldMejor);
					quitar(posicion[0], posicion[1], i, baldosas, solar, baldUs);
				}
			}
		}
		
	}
	
	public void cambSolar(int [][] solar, int [][] solMejor, int [] baldUs, int [] baldMejor){
		for (int i=0; i<solar.length;i++){
			for(int j=0;j<solar.length;j++){
				solMejor[i][j]=solar[i][j];
			}
		}
		for(int i=0;i<baldUs.length;i++){
			baldMejor[i]=baldUs[i];
		}
	}
	
	
	public int  numBald(int [] bald) {
		int total=0;
		for(int i=0; i<bald.length;i++) {
			total+=bald[i];
		}
		
		return total;
	}
	
	public static void mostSolar(int[][] solar) {
		for (int i = 0; i < solar.length; i++) {
			for (int j = 0; j < solar.length; j++) {
				System.out.print(solar[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n-------------");
	}
	public void quitar(int i, int j, int t, int [] baldosas, int [][]solar, int[] baldUs) {
		
		int a, b = 0;
		for (a = i; a < baldosas[t] + i; a++) {
			for (b = j; b < baldosas[t] + j; b++) {
				solar[a][b]= 0;
			}
		}

		baldUs[t] -= 1;


	}

	public boolean cabeBack(int t, int[] posicion, int[] baldosas, int solar[][]) {
		boolean cabe = false;
		boolean parar = false;

		for (int i = 0; i < solar.length && !parar; i++) {
			for (int j = 0; j < solar.length && !parar; j++) {
				// compruebo q el primer eleme es 0 y q no se sale de la dimensio del solar
				if (solar[i][j] == 0 && (solar.length - j) >= baldosas[t] && (solar.length - i) >= baldosas[t]) {
					// compruebo todas las posicions q ocupara la baldosa estan a 0
					for (int a = i; a <= (baldosas[t] + i) - 1; a++) {
						for (int b = j; b <= (baldosas[t] + j) - 1; b++) {
							if (solar[a][b] != 0) {
								a = baldosas[t] + i + 1;
								b = baldosas[t] + j + 1;
								cabe = false;

							} else {
								cabe = true;
								posicion[0] = i;
								posicion[1] = j;
								parar = true;

							}
						}
					}
				}
			}
		}
		return cabe;
	}

	public void ponerBack(int i, int j, int t, int[] baldosas, int[][] solar, int[] baldUs) {
		int a, b = 0;
		for (a = i; a < baldosas[t] + i; a++) {
			for (b = j; b < baldosas[t] + j; b++) {
				solar[a][b] = baldosas[t];
			}
		}
		baldUs[t] += 1;
	}

	// Metodo que comprueba si se ha completado el solar
	public boolean completado(int[][] solar) {
		boolean exito = true;
		for (int f = 0; f < solar.length; f++) {
			for (int c = 0; c < solar.length; c++) {
				if (solar[f][c] == 0) {
					exito = false;
					c = f = solar.length;
				}
			}
		}
		return exito;
	}

}
