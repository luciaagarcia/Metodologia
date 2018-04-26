package utilidades;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import utilidades.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Carmen.Lacave
 */
public class PruebaOrdenacion {
	public static void main(String[] args){
		apartado1();
		apartado2();
	}

	public static void apartado1(){
		char repetir;
		do{
			System.out.println("\n\nRealizaremos una prueba para un tamano de vector dado");
			int[] A=crearVector();
			int[] B=new int[A.length];

			System.arraycopy(A,0,B,0,A.length);
			System.out.println("A\n"+MatricesOperaciones.mostrar(A));

			char medida=leer.caracter("En que unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");
			long tb0= obtenerTiempo(medida);
			burbuja(B);
			long tb1=obtenerTiempo(medida);

			int[] C=new int[A.length];
			System.arraycopy(A,0,C,0,A.length);
			System.out.println("  N   |	     Burbuja	   |  SeleccionDirecta  |");
			long ts0= obtenerTiempo(medida);
			seleccionDirecta(C);
			long ts1=obtenerTiempo(medida);

			//Impresion
			System.out.println("  "+A.length+" |	 "+(tb1-tb0)+"	| 	 "+(ts1-ts0)+" 	 |");
			System.out.println("Burbuja: "+MatricesOperaciones.mostrar(B)+"\nSelec Dir: "+MatricesOperaciones.mostrar(C));
			repetir=Character.toUpperCase(leer.caracter("Quieres repetir la prueba? (S=si/N=no)"));
		}while (repetir=='S');
	}


	public static int[] crearVector(){
		int[] V=null;
		char fuenteDatos=leer.caracter("Desde donde quieres cargar los datos:\n T=teclado\n F=archivo\n A=crearlo con valores aleatorios");
		fuenteDatos=Character.toUpperCase(fuenteDatos);
		while (fuenteDatos!='T' && fuenteDatos!='F' && fuenteDatos!='A'){
			System.out.println("Ha introducido una opcion incorrecta. Vuelva a intentarlo");
			fuenteDatos=Character.toUpperCase(leer.caracter("Desde donde quieres cargar los datos:\n T=teclado\n F=archivo\n A=crearlo con valores aleatorios"));
		}
		String fuenteDat = Character.toString(fuenteDatos);

		switch(fuenteDat) {
		case "T":V=cargarDatosTeclado();
		break;
		case "A":V=cargarDatosAleatorio();
		break;
		case "F":V=cargarDatosArchivo("Prueba1_1.dat");
		}

		return V;
	}

	public static int[] cargarDatosTeclado(){
		int vectorSize=(leer.entero("Introduce tamaño del vector"));
		int [] Vec=new int [vectorSize];
		for (int i=0; i<vectorSize; i++) {
			int num=(leer.entero("Introduzca numero de la posicion "+i+"\n"));
			Vec[i]=num;
		}
		return Vec;


	}

	public static int[] cargarDatosArchivo(String nombre){
		try{
			System.out.println("Leyendo archivo...");

			File f=new File(nombre);
			Scanner datos;
			datos = new Scanner(f);
			int size=datos.nextInt();
			int [] Vec=new int [size];
			int  i=0;

			while(datos.hasNext()){
				Vec[i]=datos.nextInt();
				i++;
			}
			datos.close();//Cerrar el fichero Auxiliar

			return Vec;
		}catch(Exception e) {
			System.out.println("Error en la lectura.");
			e.printStackTrace();
			return null;
		}
	}

	public static int[] cargarDatosAleatorio(){
		return cargarDatosAleatorio(leer.entero("Introduce tamano del vector"));
	}

	public static int[] cargarDatosAleatorio(int size){
		int [] V=new int [size];
		for (int i=0; i<V.length-1;i++) {
			V[i]=(int) ((Math.random() * size)+1);			
		}
		return V;
	}

	public static void burbuja(int[] t){ //Complejidad: n^2 
		for (int i = 1; i <t.length; i++)
			for (int j = t.length-1; j>=i; j--)
				if (t[j-1] > t[j]) {
					int aux=t[j-1];
					t[j-1]=t[j];
					t[j]=aux;
				}
	}

	public static void seleccionDirecta(int[] t){//Complejidad: n^2
		for (int i=0; i<t.length-1; i++){
			int minimo = i;
			for (int j=i+1; j<=t.length-1; j++){
				if (t[j] < t[minimo])
					minimo = j;
			}
			int aux=t[i];
			t[i]=t[minimo];
			t[minimo]=aux;
		}
	}

	public static void apartado2(){

		System.out.println("\n\nAhora realizaremos pruebas con distintos tamaños del vector");
		int[] valoresN= {100, 500, 1000, 5000, 8000, 9000, 10000, 11000, 20000, 50000};

		char medida=leer.caracter("En que unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");

		System.out.println("  N     |    	 Burbuja	|  SeleccionDirecta  |");

		for(int i=0;i<valoresN.length;i++) {
			int[] A=cargarDatosAleatorio(valoresN[i]);
			
			int[] B=new int[A.length];
			System.arraycopy(A,0,B,0,A.length);
			long tb0 = obtenerTiempo(medida);
			burbuja(B);
			long tb2 = obtenerTiempo(medida); 
			int[] C=new int[A.length];
			System.arraycopy(A,0,C,0,A.length);
			long ts0 = obtenerTiempo(medida);
			seleccionDirecta(C);
			long ts2 = obtenerTiempo(medida);
			System.out.println(A.length+"	|"+"		"+(tb2-tb0)+"|"+"		"+(ts2-ts0)+"	|");

		}

		System.out.printf("\n\n");
	}

	static long obtenerTiempo(char medida){
		long tiempo=0;

		if(medida=='n'||medida=='N') {
			tiempo = System.nanoTime();
		}else if(medida=='m'||medida=='M') {
			tiempo = System.currentTimeMillis();

		}
		return tiempo;
	}


}