package co.edu.uniquindio.programacion3.hilos_CreacionV1;

public class ManejadorHilo {

	HiloServicio1 hiloServicio1;
	HiloServicio2 hiloServicio2;
	HiloServicio3 hiloServicio3;
	
	
	public ManejadorHilo() {
		
	}

	public void starHiloServicio1() {
		hiloServicio1 = new HiloServicio1();
	}

	public void detenerHiloServicio1() {
		
		if(hiloServicio1 != null)
			hiloServicio1.detener();
	}
	
	public void starHiloServicio2() {
		hiloServicio2 = new HiloServicio2();
	}

	public void detenerHiloServicio2() {
		
		if(hiloServicio2 != null)
			hiloServicio2.detener();
	}
	
	public void starHiloServicio3() {
		hiloServicio3 = new HiloServicio3();
	}

	public void detenerHiloServicio3() {
		
		if(hiloServicio3 != null)
			hiloServicio3.detener();
	}
	
	
}
