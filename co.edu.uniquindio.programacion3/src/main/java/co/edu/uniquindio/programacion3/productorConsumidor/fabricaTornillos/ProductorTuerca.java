package co.edu.uniquindio.programacion3.productorConsumidor.fabricaTornillos;

public class ProductorTuerca extends Thread {
	
	private CajaTuercas cajaTuercas; // Almacena los datos que se van produciendo.

	public ProductorTuerca(CajaTuercas cajaTuercas) {
		this.cajaTuercas = cajaTuercas;
		setPriority(MAX_PRIORITY);
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			cajaTuercas.put("Tuerca"+i); // Se almacena el dato en el contenedor.
			System.out.println("Productor Tuercas. put: " + i);
			try {
				sleep(5000); // Espera una cantidad de tiempo aleatoria (hasta 100 milisegundos)
			} catch (InterruptedException e) {
			}
		}
	}
}