package Aula_05;

import java.util.Scanner;

public class Operadores_Aritimeticos_Subtracao {

	public static void main(String[] args) {
		double valor1, valor2, res;
		boolean status;
		
		Scanner ler = new Scanner (System.in);
		
		System.out.println("Informe o primeiro valor");
			valor1 = ler.nextDouble();
		
		System.out.println("Informe o segundo valor");
		 	valor2 = ler.nextDouble();
		 
		 res = valor1 - valor2;
		 	System.out.println("A subtração entre os valores é " + res);
		 	
		 status = valor1 <= valor2;
		  	System.out.println("O primeiro valor é menor ou igual: " + status);
		
	}

}
