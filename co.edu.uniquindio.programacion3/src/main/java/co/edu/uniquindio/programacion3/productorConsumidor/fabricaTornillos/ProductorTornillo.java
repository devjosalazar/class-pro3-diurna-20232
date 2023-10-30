package co.edu.uniquindio.programacion3.productorConsumidor.fabricaTornillos;

public class ProductorTornillo extends Thread {
	
	private CajaTornillos cajaTornillo; // Almacena los datos que se van produciendo.

	public ProductorTornillo(CajaTornillos cajaTornillos) {
		this.cajaTornillo = cajaTornillos;
		setPriority(MAX_PRIORITY);
	}

	public void run() 
	{
		for (int i = 1; i <= 10; i++) {
			cajaTornillo.put("Tornillo"+i); // Se almacena el dato en el contenedor.
			System.out.println("Productor Tornillos. put: " + i);
			try {
				sleep(5000); // Espera una cantidad de tiempo aleatoria (hasta 100 milisegundos)
			} catch (InterruptedException e) {
			}
		}
	}

	
}