package co.edu.uniquindio.programacion3.productorConsumidor.fabricaTornillos;

import java.util.ArrayList;

public class CajaTornillos {
	private ArrayList<String> tornillos = new ArrayList<>(); // Contiene la lista de tornillos, que se almacena con put() y se devuelve con get()
	public boolean hayTornillo = false; // Flag (bandera) que indica si el objeto tiene el dato o no.

	// En este m�todo put() antes de almacenar el valor en la variable dato debe asegurarse que el valor anterior ha sido consumido.
	public synchronized void put(String valor) {
		while (hayTornillo == true) { // Si todav�a hay valor se suspende la ejecuci�n del hilo mediante el m�todo wait().
			try {
				/**
				 * Se suspende el hilo indefinidamente hasta que se le env�e una 'se�al' con el m�todo notify() o notifyAll()
				 * Cuando la se�alizaci�n mediante notify() lo produce el m�todo getTornillo(), el m�todo continua, asume que el tornillo
				 * ya fue consumido y posteriormente...
				 **/
				wait();
			} catch (InterruptedException e) {
			}
		}
		// Almacena el tronillo en la lista de tornillos y notifica que hay un tornillo disponible.
		tornillos.add(valor);
		hayTornillo = true;
		notifyAll();
	}
	
	// En este m�todo get() chequea si hay un tornillo disponible (no lo hay si hayTornillo es falso)	
	public synchronized String getTornillo() {
		while (hayTornillo == false) {
			try {
				/**
				 * Si no hay tornillo espera hasta que le avisen.
				 * Una vez notificado desde el m�todo put(), posteriormente...
				 **/
				wait(); 
			} catch (InterruptedException e) {
			}
		}
		// Cambia el valor de la bandera y devuelve el tornillo. Pero antes, notifica que el tornillo ya ha sido consumido y que se puede almacenar otro.
		hayTornillo = false;
		notifyAll();
		String tornillo = tornillos.get(0);
		tornillos.remove(tornillo);
		return tornillo;
	}
}