package guiMetod;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import utilidades.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Carmen.Lacave
 */
public class Auxiliar {

	public static void apartado1(IGrafica frame){
		int[] A=crearVector(frame);
		int[] B=new int[A.length];
		frame.appende(MatricesOperaciones.mostrar(A)+"\n---------------------------------------------------------------------");

		System.arraycopy(A,0,B,0,A.length);

		char medida=frame.get_time(1);
		long tb0= obtenerTiempo(medida);
		burbuja(B);
		long tb1=obtenerTiempo(medida);

		int[] C=new int[A.length];
		System.arraycopy(A,0,C,0,A.length);
		long ts0= obtenerTiempo(medida);
		seleccionDirecta(C);
		long ts1=obtenerTiempo(medida);

		//Impresion		
		long tbur=tb1-tb0;
		long tdir=(ts1-ts0);
		frame.textoBurb1.setText(String.valueOf(tbur));
		frame.textoSel1.setText(String.valueOf(tdir));
		frame.textoLong1.setText(String.valueOf(A.length)+" digitos.");
		if(tbur<tdir) {
			frame.lblBurbuj1.setForeground(new Color(0, 0, 255));frame.lblSeleccionDirecta1.setForeground(new Color(255, 0, 0));
		}else frame.lblSeleccionDirecta1.setForeground(new Color(0, 0, 255));frame.lblBurbuj1.setForeground(new Color(255, 0, 0));
		frame.appende(MatricesOperaciones.mostrar(C)+"\n---------------------------------------------------------------------");
	}

	public static void apartado2(IGrafica frame){  
		int[] valoresN;
		int[] valoresNo= {100, 500, 1000, 5000, 8000, 9000, 10000, 11000, 20000, 50000};
		int[] valoresNe= {10000, 20000, 30000, 50000, 60000, 80000, 90000, 100000, 130000 ,150000 };

		//poner un checkbox para seleccionar si quieres burbuja, sel o ambos

		if(frame.lblExtrem.isVisible()) {
			valoresN=valoresNe;
			frame.textArea.setFont(new Font("Bookman Old Style", Font.BOLD, 97));
			frame.appende("TE VAS A CAGAR");
			frame.textArea.setFont(new Font("Consolas", Font.PLAIN, 13));
		}else valoresN=valoresNo;
		char medida=frame.get_time(2);

		long [][] tabla=new long[3][10];
		frame.appende("\n------------ Ejecutando Algoritmos ------------");
		for(int i=0;i<valoresN.length;i++) {
			int[] A=new int[valoresN[i]]; 
			for (int z=0; z<A.length-1;z++) {
				A[z]=(int) ((Math.random() * valoresN[i])+1);			//OJO CON ESTO QUE HE CAMBIADO A valoresN[i], QUE ESTA BIEN, LO QUE ESTA MAL ES valoresN.length
			}
			frame.appende(MatricesOperaciones.mostrar(A)+"\n---------------------------------------------------------------------");
			int[] B=new int[A.length];
			System.arraycopy(A,0,B,0,A.length);

			long tbur=0,tdir=0;
			if(frame.lblbu.isSelected()) {
				long tb0 = obtenerTiempo(medida);
				burbuja(B);
				long tb2 = obtenerTiempo(medida); 
				tbur=tb2-tb0;

			}
			int[] C=new int[A.length];
			System.arraycopy(A,0,C,0,A.length);

			if(frame.lblSeleccionDirecta.isSelected()) {
				long ts0 = obtenerTiempo(medida);
				seleccionDirecta(C);
				long ts2 = obtenerTiempo(medida);

				tdir=(ts2-ts0);
			} 
			int[] D=new int[A.length];
			System.arraycopy(A,0,D,0,A.length);
			
			long tm0 = obtenerTiempo(medida);
			Inversiones.MergeSort(D, 0, D.length-1);
			long tm2 = obtenerTiempo(medida);
			long tmerg=(tm2-tm0);

			frame.tablaValor.setValueAt(A.length, i, 0);
			frame.tablaValor.setValueAt(tbur, i, 1);
			frame.tablaValor.setValueAt(tdir, i, 2);
			frame.tablaValor.setValueAt(tmerg, i, 3);
			long [] men=new long[3];
			men[0]=tbur;
			men[1]=tdir;
			men[2]=tmerg;

			switch(FindSmallest(men)) {
			case 0:
				frame.tablaValor.setValueAt("Burbuja", i, 4);
				break;
			case 1:
				frame.tablaValor.setValueAt("S.Dir", i, 4);
				break;
			case 2:
				frame.tablaValor.setValueAt("Merge", i, 4);
				break;
			}
			frame.appende(MatricesOperaciones.mostrar(B)+"\n---------------------------------------------------------------------");
		} 
	}

	public static int FindSmallest (long [] arr1){//start method

	       int index = 0;
	       long min = arr1[index];
	       for (int i=1; i<arr1.length; i++){

	           if (arr1[i] < min ){
	               min = arr1[i];
	               index = i;
	           }


	       }
	       return index ;

	}
	public static int[] crearVector(IGrafica frame){
		int[] V=null;
		switch(frame.get_FormVec()) {
		/*case "T":V=cargarDatosTeclado(inter);
		break;*/
		case "A":if(frame.comprobarEnt(frame.textAleat.getText())>0) {V=cargarDatosAleatorio(frame);}else frame.appende("Introduzca un numero valido para el tamaño del vector");
		break;
		case "F":V=cargarDatosArchivo("Prueba1_1.dat",frame);
		}
		return V;
	}

	public static int[] cargarDatosTeclado(panelBurb inter, JTextArea textTecla){
		int space=1,e=0;
		String texto=textTecla.getText();
		char[] texto_arr = texto.toCharArray();
		for(int i=0;i<texto_arr.length;i++) {
			if(texto_arr[i]==' ') {
				space++;
			}
		} 
		int [] Vec=new int [space];
		String num=null;
		for(int i=0;i<Vec.length;i++) {
			//Ver los numeros que hay antes de un espacio
			if(texto_arr[i]!=' ') {
				num=String.valueOf(texto_arr[i]);
				System.out.println(num);

			}else if(texto_arr[i]==' ')num=null;

			try {
			Vec[e]=Integer.parseInt(num);e++;
		
			}catch(NumberFormatException numer){
				
			}
		}
		inter.appende(String.valueOf(Vec[1]));
		inter.textoLong1.setText(String.valueOf(space)+" digitos.");
		inter.appende(String.valueOf(space));

		for (int i=0; i<space; i++) {

		}

		return Vec;


	}

	public static int[] cargarDatosArchivo(String nombre, IGrafica frame){
		try{ 
			frame.appende("Leyendo archivo...");

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
			frame.appende("Error en la lectura del archivo");
			e.printStackTrace();
			return null;
		}
	}

	public static int[] cargarDatosAleatorio(IGrafica frame){
		return cargarDatosAleatorio(frame.comprobarEnt(frame.textAleat.getText()));
	}

	public static int[] cargarDatosAleatorio(int size){
		int [] V=new int [size];
		for (int i=0; i<V.length-1;i++) {
			V[i]=(int) ((Math.random() * size)+1);			
		}
		return V;
	}

	public static void burbuja(int[] t){
		for (int i = 1; i <t.length; i++)
			for (int j = t.length-1; j>=i; j--)
				if (t[j-1] > t[j]) {
					int aux=t[j-1];
					t[j-1]=t[j];
					t[j]=aux;
				}
	}

	public static void seleccionDirecta(int[] t){
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