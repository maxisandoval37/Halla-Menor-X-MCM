package logica;

public class HallarX_MCM {

	public boolean esMultiplo(int n1, int n2) {
		return (n1 % n2 == 0);
	}

	public int hallarMCM(int a, int b) {
		int multiplo;

		if (a > b)
			multiplo = a;
		else
			multiplo = b;

		while (multiplo % a != 0 || multiplo % b != 0)
			multiplo++;

		return multiplo;
	}

	public int hallarX_MCD(int a, int MCM) {
		int x = 1;
		while (hallarMCM(a, x) != MCM) {
			x++;
		}
		return x;
	}
	
	public static int cantDivDeUnN(int numero) {
		int cont=1;
		int cantDivosores=0;
		
		while (cont<numero) {
			if (numero%cont==0)
				cantDivosores++;
			cont++;
		}
		return cantDivosores;
	}
}
