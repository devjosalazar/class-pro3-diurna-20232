package co.edu.uniquindio.programacion3.productorConsumidor.fabricaTornillos;

import java.util.ArrayList;

public class CajaTuercas {
	
	private ArrayList<String> tuercas = new ArrayList<>(); // Contiene la tuerca, que se almacena con put() y se devuelve con getTuerca()
	boolean hayTuerca = false; // Flag (bandera) que indica si el objeto tiene el dato o no.

	// En este m�todo put() antes de almacenar la tuerca en la lista de tuercas  debe asegurarse que la tuerca anterior ha sido consumida.
	public synchronized void put(String tuerca) {
		while (hayTuerca == true) { // Si todav�a hay tuercas se suspende la ejecuci�n del hilo mediante el m�todo wait().
			try {
				/**
				 * Se suspende el hilo indefinidamente hasta que se le env�e una 'se�al' con el m�todo notify() o notifyAll()
				 * Cuando la se�alizaci�n mediante notify() lo produce el m�todo get(), el m�todo continua, asume que el dato
				 * ya fue consumido y posteriormente...
				 **/
				wait();
			} catch (InterruptedException e) {
			}
		}
		// Almacena el valor en dato y notifica que hay un dato disponible.
		tuercas.add(tuerca);
		hayTuerca = true;
		notifyAll();
	}
	
	// En este m�todo get() chequea si hay una tuerca disponible (no lo hay si hayTuerca es falso)	
	public synchronized String getTuerca() {
		while (hayTuerca == false) {
			try {
				/**
				 * Si no hay dato espera hasta que le avisen.
				 * Una vez notificado desde el m�todo put(), posteriormente...
				 **/
				wait(); 
			} catch (InterruptedException e) {
			}
		}
		// Cambia el valor de la bandera y devuelve la tuerca. Pero antes, notifica que la tuerca ya ha sido consumida y que se puede almacenar otro.
		hayTuerca = false;
		notifyAll();
		String tuerca = tuercas.get(0);
		tuercas.remove(tuerca);
		return tuerca;
	}
}