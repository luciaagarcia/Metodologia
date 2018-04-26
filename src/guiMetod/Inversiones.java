package guiMetod;
import java.io.File;
import utilidades.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Inversiones {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int[] v = new int[0];
		boolean salir = true;
		try {
		do {
			int contador = 0;
			System.out.println(
					"\nElija un fichero: \n1.Test 0 \n2.Test 3\n3.Test 6 \n4.Test 242698 \n5.Vector aleatorio \n \n0.Cerrar el programa");
			String opcion = teclado.next();
			switch (opcion) {
			case "1":
				v = lecturaFich("InversionsTest_0.dat");
				break;
			case "2":
				v = lecturaFich("InversionsTest_3.dat");
				break;
			case "3":
				v = lecturaFich("InversionsTest_6.dat");
				break;
			case "4":
				v = lecturaFich("InversionsTest_242698.dat");
				break;
			case "5":
				System.out.println("Introducir tamaño: ");
				int tam = teclado.nextInt();
				v=PruebaOrdenacion.cargarDatosAleatorio(tam);
				break;
			case "0":
				salir = false;
				break;
			default: 
				System.out.println("Opcion incorrecta. \n");
				v= new int[0];
				break;
			}
			if(salir==true && (v.length>3)) {
			contador=MergeSort(v, 0, v.length - 1);
			System.out.println("El vector ordenado es:");
			for (int i = 0; i < v.length; i++) {
				System.out.println(v[i] + " ");
			}
			System.out.println("\nNumero de inversiones:" + contador);
			}
		} while (salir == true);
		teclado.close();
		}catch(Exception e) {
		}
	} // Fin del main

	public static int MergeSort(int[] v, int li, int ls) {
		int med;
		int contador = 0;
		if (li < ls) {
			med = (li + ls) / 2; 
			contador =MergeSort(v, li, med ); 
			contador+=MergeSort(v, med + 1, ls );
			contador+=MezclaOrdenada(v, li, med, ls);
		}
		return contador;
	}// Fin del MergeSort

	public static int MezclaOrdenada(int v[], int li, int med, int ls) {
		int recorre = li;
		int iz = li;
		int der = med + 1;
		int w[] = new int[v.length];
		int contador=0;

		while ((iz <= med) && (der <= ls)) {
			if (v[iz] < v[der]) {
				w[recorre] = v[iz];
				iz++;
			} else {
				w[recorre] = v[der];
				contador+=(der-recorre);
				der++;
			}
			recorre++;
		} // Completamos w con lo que nos queda del subvector izquierdo
		for (int k = iz; k <= med; k++) {
			w[recorre] = v[k];
			recorre++;
		} // Completamos el vector w con lo que nos queda del sobvector derecho
		for (int k = der; k <= ls; k++) {
			w[recorre] = v[k];
			recorre++;
		} // Volcamos todo el contenido del vector w en el vector v
		for (int k = li; k <= ls; k++) {
			v[k] = w[k];
		}
		return contador;
	}// Fin de MezclaOrdenada

	public static int[] lecturaFich(String ruta) {
		int[] vec = null;
		try {
			File f = new File(ruta);
			Scanner datos = new Scanner(f);
			int size = leerLineas(ruta);
			vec = new int[size];
			int i = 0;
			while (datos.hasNext()) {
				int dato = datos.nextInt();
				vec[i] = dato;
				i++;
			}
			datos.close();
			return vec;

		} catch (InputMismatchException e) {
			System.out.println("Error en la lectura del fichero.");
		} catch (FileNotFoundException e1) {
			System.out.println("No existe el fichero");
		}
		return null;
	}

	public static int leerLineas(String ruta) {
		int size = 0;

		File f = new File(ruta);
		Scanner datos;
		
		try {
			datos = new Scanner(f);
			while (datos.hasNextLine()) {
				size++;
				datos.nextLine();
			}
			datos.close();
			return size;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	return size;
	}
}