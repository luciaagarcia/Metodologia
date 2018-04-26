package guiMetod;


public class MergeSort{
 	//EN VERDAD ES EL QUICKSORT
	public static void main(String[] args){
		int[] v={/*1,2,2,1,2};//*/8,12,14,8,15,13,10,7,11,9,4,6,7,5,2}; 
        System.out.println("A\n"+MatricesOperaciones.mostrar(v));
        quicksortA(v);
        System.out.println("A\n"+MatricesOperaciones.mostrar(v));    
        quicksortD(v);
        System.out.println("A\n"+MatricesOperaciones.mostrar(v));    

	}
	
	//ESTA CLASE ES BUENA A DiA 3-3-2016	
		public static void intercambia(int[] v, int pos1, int pos2){
			int aux=v[pos1];
			v[pos1]=v[pos2];
			v[pos2]=aux;
		}
		
		public static void quicksortA(int [] v){
		     quicksortA(v,0,v.length-1);
		}
		
		public static void quicksortA(int[] v, int li, int ls){
			if (li<ls){
				int pos=divideA(v,li,ls);
				quicksortA(v, li, pos-1);
				quicksortA(v, pos+1, ls);
			}
		}

		public static int divideA(int[] v, int li, int ls){
			int pivote=v[li];
	    	int izq=li+1; int der=ls;
	        while(izq<der && v[izq]<=pivote ) izq++;
	        while (v[der]>pivote) der--;
			while (izq<der){
	    		intercambia(v,izq,der);
	            do{izq++;}while(v[izq]<=pivote);
	            do{der--;}while(v[der]>pivote);
	        }
			intercambia(v,li,der);
			return der;
		}
		   
		 public static void quicksortD(int [] v){
		        quicksortD(v,0,v.length-1);
		    }
		
			public static void quicksortD(int[] v, int li, int ls){
				if (li<ls){
					int pos=divideD(v,li,ls);
					quicksortD(v, li, pos-1);
					quicksortD(v, pos+1, ls);
				}
			}

			public static int divideD(int[] v, int li, int ls){
				int pivote=v[li];
		    	int izq=li+1; int der=ls;
		        while(izq<der && v[izq]>=pivote ) izq++;
		        while (v[der]<pivote) der--;
				while (izq<der){
		    		intercambia(v,izq,der);
		            do{izq++;}while(v[izq]>=pivote);
		            do{der--;}while(v[der]<pivote);
		        }
				intercambia(v,li,der);
				return der;

			}
		
}