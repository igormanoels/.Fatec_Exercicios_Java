package teste;

public class Main {
	
	public static void main(String[] args) {
		int[] array = {1, 5, 12};
		
		System.out.printf("Menor número faltando: %.0f.", MenorNumeroFaltando(array));
		
	}
	
	public static double MenorNumeroFaltando(int[] array)
	{
		int n = 0;
		for (int i = array[0]; i <= array[array.length-1]; i++) {
			for (int j = n; j < array.length; j++) {
				if (array[j] == i) {
					break;
				} else {
					return i;
				}
			}
			n++;
		}
		return array[array.length+1];
	}

}
