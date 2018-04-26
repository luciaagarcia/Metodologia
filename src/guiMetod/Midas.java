package guiMetod;

import java.util.Random;
import utilidades.MatricesOperaciones;
public class Midas {
	public static void main(String[] args){
		Random rnd = new Random();
		int tamanioBolsa=rnd.nextInt(10);
		int[] bolsaMonedas=new int[tamanioBolsa];
		echaMonedasEnBolsa(bolsaMonedas);
		System.out.println("La moneda falsa está en"
				+posicionFalsa(bolsaMonedas,0,bolsaMonedas.length-1));
		System.out.println(MatricesOperaciones.mostrar(bolsaMonedas));
	}
	static void echaMonedasEnBolsa (int[] bolsa){
		Random rnd=new Random();
		int posFalsa=rnd.nextInt(bolsa.length);
		for (int i = 0; i < bolsa.length; i++) {
			if (i!=posFalsa)
				bolsa[i] = 1;
			else bolsa[i] = 0;
		}
	}
	static int posicionFalsa(int[] bolsa, int li, int ls){
		int pos=-1;
		if (li==ls)
			pos=li;
		else {
			int mitad=(li+ls)/2;
			if ((ls-li)%2==0){ //nº monedas impar
				int pesoizq=pesar(bolsa,li,mitad-1);//dejamos la del centro sin pesar
				int pesoder=pesar(bolsa, mitad+1, ls);
				if (pesoizq<pesoder)
					pos=posicionFalsa(bolsa,li,mitad-1);
				else if (pesoizq>pesoder)
					pos=posicionFalsa(bolsa,mitad+1,ls);
				else pos=mitad;
			}
			else{//nº de monedas par
				int pesoizq=pesar(bolsa,li,mitad);
				int pesoder=pesar(bolsa, mitad+1, ls);
				if (pesoizq<pesoder)
					pos=posicionFalsa(bolsa,li,mitad);
				else if (pesoizq>pesoder)
					pos=posicionFalsa(bolsa,mitad+1,ls);
			}
		}
		return pos;
	}
	static private int pesar(int[] bolsa, int li, int ls){
		int peso=0;
		for (int i=li; i<=ls;i++)
			peso=peso+bolsa[i];
		return peso;
	}

}