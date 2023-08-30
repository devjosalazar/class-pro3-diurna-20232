package co.edu.uniquindio.programacion3.recursividad.practica;

public class E1_EjercicioPractica {

	public static void main(String[] args) {
		int numero = 123;
		int resultado = 0;
		resultado = contarDigitos(numero);
	}

	private static int contarDigitos(int numero) {
		int valorRetorno = 0;
		if(numero < 10){
			return 1;
		}else{
			valorRetorno = contarDigitos(numero/10);
			valorRetorno = valorRetorno + 1;
			return valorRetorno;
			//return contarDigitos(numero/10)+1;
		}
	}

}
