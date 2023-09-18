package co.edu.uniquindio.programacion3.parciales.parcial1_22;


public class Punto1 {

	public static String [][] parqueaderoUQ = {

			{ "L",      " ",     "L",     "L",     " ",      "L",      " "}, 
			{ "L",      " ",     "L",     "CARRO", " ",      "L",      " " },
			{ " ",      " ",     " ",     "CARRO", " ",      " ",      " " },
			{ "CARRO",  " ",     "CARRO", "CARRO", "CARRO1", "CARRO1", " "},
			{ " ",      " ",     " ",     " ",     " ",      "L",      " "}, 
			{ " ",      "CARRO", "CARRO", " ",     " ",      "L",      " "},
			{ " ",      "CARRO", "CARRO", " ",     "CARRO",  "CARRO",  " "},
			{ " ",      " ",     "CARRO", " ",     " ",      " ",      " "},
			{ " ",      "CARRO", "CARRO", " ",     "CARRO",  " ",      "CARRO"},
			{ " ",      " ",     "R2",    " ",     "CARRO",  " ",      "R"},
			{ "CARRO",  " ",     "R",     " ",     "CARRO",  "CARRO",  "R"},
			{ "R1",     " ",     "R",     " ",     " ",      " ",      "CARRO1"},
			
	};

	/* --------------------- PRUEBA DEL ALGORITMO --------------------- */
	public static void main(String[] args) {

		Punto1 m = new Punto1(); // construimos un
															// objeto de la
															// clase Laberinto
															// por defecto
		//m.parqueaderoUQ[6][0] = ""; // introducimos en este caso, la salida (X) en
									// las coordenadas (1,1)
		m.resuelve(0, 6); // ahora, introducimos la entrada (S) en las
							// coordenadas (8,1) y llamamos al algoritmo
		m.imprimirLaberintoVia(parqueaderoUQ, 0, 0); // imprimimos el laberinto
													// ya resuelto (si tiene
													// soluci�n)
	}

	/* ----------------- IMPLEMENTACI�N DEL ALGORITMO ----------------- */
	public void resuelve(int x, int y) { // permite introducir unas coordenadas
											// (x, y)
		if (paso(x, y)) { // intentar� resolver el laberinto en estas
							// coordenadas
			parqueaderoUQ[x][y] = "ENTRADA"; // introduce en las coordenadas (x, y) la
									// entrada
		}
	}

	private boolean paso(int x, int y) {
		if (x >= 0 && x <= parqueaderoUQ.length - 1  ) {

			if (y >= 0 && y <= parqueaderoUQ[x].length - 1 ) {

				if (parqueaderoUQ[x][y] == "R2") { 
					
					parqueaderoUQ[x][y] = "OCUPADO_R2";
					imprimirLaberintoVia(parqueaderoUQ, 0, 0);
					System.out.println();
					System.out.println();
					return false;
					//return true;  // luego, el algoritmo termina
				}
				
				if (parqueaderoUQ[x][y] == "R1") { 
					
					parqueaderoUQ[x][y] = "OCUPADO_R1";
					imprimirLaberintoVia(parqueaderoUQ, 0, 0);
					System.out.println();
					System.out.println();
					return false;
					//return true;  // luego, el algoritmo termina
				}
				
				
//				imprimirLaberintoVia(laberinto, x, y);
//				System.out.println();
//				System.out.println();
////				paso(x, y);

				if (parqueaderoUQ[x][y] == "CARRO" || parqueaderoUQ[x][y] == "CARRO1" || parqueaderoUQ[x][y] == "R" || parqueaderoUQ[x][y] == "+" || parqueaderoUQ[x][y] == "L") { // si
																									// llegamos
																									// a
																									// una
																									// pared
																									// o
																									// al
																									// mismo
																									// punto,
					return false; // entonces el laberinto no puede resolverse y
									// termina.
				}

				// si no se cumple ninguna de estas dos situaciones, quiere
				// decir que nos encontramos en un
				// caso intermedio, por lo tanto, que empezamos a recorrer o
				// todav�a no hemos llegado a nada
				parqueaderoUQ[x][y] = "+"; // marcamos la posici�n como visitada (si
										// es la primera, en las coordenadas x e
										// y
			} else {
				return false;
			}

		} else {
			return false;
		}
		boolean result; // se coloca S de START)
		
		result = paso(x, y - 1); // intentamos ir hacia la IZQUIERDA. Tercera
		// llamada recursiva
		
		if (result)
		return true; // si el resultado es el final, entonces el algoritmo
					// termina


		result = paso(x, y + 1); // intentamos ir hacia la DERECHA. Primera
									// llamada recursiva
		if (result)
			return true; // si el resultado es el final, entonces el algoritmo
							// termina
		
		result = paso(x + 1, y); // intentamos ir hacia ABAJO. Cuarta llamada
		// recursiva
		
		if (result)
		return true; // si el resultado es el final, entonces el algoritmo
						// termina

		result = paso(x - 1, y); // intentamos ir hacia ARRIBA. Segunda llamada
									// recursiva
		if (result)
			return true; // si el resultado es el final, entonces el algoritmo
							// termina

		
		

		// si no hemos encontrado la soluci�n en estos cuatros movimientos,
		// volvemos atr�s, aunque hay que
		// considerar que en este punto, todas las llamadas recursivas han
		// finalizado. Si en ninguna de ellas
		// se ha conseguido el �xito, entonces el algoritmo termina y devuelve
		// false.
		parqueaderoUQ[x][y] = " "; // en el caso de no ser el resultado, se marca
								// con +. Ya fue pisado
		return false; // vuelta atr�s si la soluci�n no se encuentra aqu�

	}

	private  void imprimirLaberintoVia(String[][] parqueaderoUQ, int x, int y) { // imprimiremos
																					// nuestra
																					// soluci�n.
		// Debido a que la clase Arrays no
		// tiene implementado
		// un m�todo toString para arrays bidimensionales,
		// lo programamos a mano
		if (x <= parqueaderoUQ.length-1 ) {
			if (y <= parqueaderoUQ[x].length-1) {
				System.out.print(parqueaderoUQ[x][y] );
				imprimirLaberintoVia(parqueaderoUQ, x, y + 1);
			} else {
				System.out.println();
				imprimirLaberintoVia(parqueaderoUQ, x + 1, y = 0);
			}

		}

	}

}
