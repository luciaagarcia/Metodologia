package utilidades;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		
		do {
			System.out.println("¿Desea introducir el numero de iteracciones? \n1.Si \n2.No \n3.Salir");
			String select = teclado.next();
			switch (select) {
			case "1":
				System.out.println("¿Cuántas iteracciones desea ver? (Entre 1 y 40)");
				int limite = teclado.nextInt();
				if(limite<=100) {
				metodos(limite);
				}else {
					System.out.println("Por favor, introduzca un numero menor de iteraciones");
				}
				break;
			case "2":
				limite = 30;
				metodos(limite);
				break;
			case "3":
				salir = true;
				break;
				default:
					System.out.print("El valor introducido no es correcto");
			}
		} while (salir == false);

	}

	public static void metodos(int limite) {
		char opt=leer.caracter("Tiempo: n=nanosegundos | m=milisegundos");
		System.out.println("Los " + limite + " primeros términos de la serie de Fibonacci son:");
		
		if (limite==1) {

			System.out.println("El primer término de la serie de Fibonacci es: \n1");

		}else {
			System.out.println("Por favor, introduzca un numero de iteracciones menor");
		}
		switch(opt) {
		case 'm':
			tiempoAlg(limite,'m');

		break;
		
		case 'n':
			tiempoAlg(limite,'n');
			break;
		}
	}

	public static void fibonacci_iter(int n) {
		int var1;
		int var2;
		if (n > 0 && n<=40) {

			var1 = 1;
			var2 = 1;


			for (int i = 2; i <= n; i++) {
			
				var2 = var1 + var2;
				var1 = var2 - var1;
			}
		}
	}
	
	public static void tiempoAlg(int limite, char medida) {
		long recur_start=0, recur_end=0, inter_start=0, inter_end=0;
		if(medida=='m') {
		inter_start = System.currentTimeMillis();
		fibonacci_iter(limite);
		inter_end = System.currentTimeMillis();
		
		recur_start = System.currentTimeMillis();
		fibonacci_recur(limite);
		recur_end = System.currentTimeMillis();
		}else if(medida=='n'){
			inter_start = System.nanoTime();
			fibonacci_iter(limite);
			inter_end = System.nanoTime();

			recur_start = System.nanoTime();
			fibonacci_recur(limite);
			recur_end = System.nanoTime();
		}
		System.out.println("\nEl método iterativo ha tardado " + (inter_end - inter_start)+" " + medida+"segundos");

		System.out.println("\nEl método recursivo ha tardado " + (recur_end - recur_start)+" " + medida+"segundos");


	}

	public static int fibonacci_recur(int n) {
		if (n < 2)
			return 1;
		else 
			return fibonacci_recur(n - 1) + fibonacci_recur(n - 2);
	}
}