package guiMetod;

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
					System.out.println("Por favor, introduzca un numero menor de iteracciones");
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
		long recur_start, recur_end, inter_start, inter_end;

		inter_start = System.currentTimeMillis();
		fibonacci_iter(limite);
		inter_end = System.currentTimeMillis();
		System.out.println("\nEl método iteractivo ha tardado " + (inter_end - inter_start) + " milisegundos");

		recur_start = System.currentTimeMillis();
		fibonacci_recur(limite);
		recur_end = System.currentTimeMillis();
		System.out.println("\nEl método recursivo ha tardado " + (recur_end - recur_start) + " milisegundos");
	}

	public static void fibonacci_iter(int n) {
		int var1;
		int var2;
		if (n > 1 && n<40) {
			System.out.println("Los " + n + " primeros términos de la serie de Fibonacci son:");

			var1 = 1;
			var2 = 1;

			System.out.print(var1 + " ");
			for (int i = 2; i <= n; i++) {
				System.out.print(var2 + " ");
				var2 = var1 + var2;
				var1 = var2 - var1;
			}
		}else if (n==1) {

			System.out.println("El primer término de la serie de Fibonacci es: \n1");

		}else {
			System.out.println("Por favor, introduzca un numero de iteracciones menor");
		}
	}

	public static int fibonacci_recur(int n) {
		if (n < 2)
			return 1;
		else 
			return fibonacci_recur(n - 1) + fibonacci_recur(n - 2);
	}
}