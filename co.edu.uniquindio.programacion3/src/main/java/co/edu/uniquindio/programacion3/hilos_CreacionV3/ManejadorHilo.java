package co.edu.uniquindio.programacion3.hilos_CreacionV3;

public class ManejadorHilo implements  Runnable{

	HiloServicio1 hiloServicio1;
	HiloServicio2 hiloServicio2;
	HiloServicio3 hiloServicio3;
	BoundedSemaphore semaphore = new BoundedSemaphore(1);

	Thread hiloServicio4;
	Thread hiloServicio5;

	int valorEntrada;
	boolean runHilo;

	public ManejadorHilo() {
		this.runHilo = true;
	}

	public void starHiloServicio1() {
		hiloServicio1 = new HiloServicio1();
		hiloServicio1.start();
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

	public void starHiloServicio4(int valorEntrada) {
		this.valorEntrada = valorEntrada;
		this.runHilo = true;

		hiloServicio4 = new Thread(this);
		hiloServicio4.start();

	}


	public void starHiloServicio5() {
		this.runHilo = true;

		hiloServicio5 = new Thread(this);
		hiloServicio5.start();
	}




	@Override
	public void run() {
		Thread hiloEjecucion = Thread.currentThread();
		try {
			semaphore.ocupar();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(hiloServicio4 == hiloEjecucion){
			ejecutarHiloServicio4();
			liberarEjecucion();
		}

		if(hiloServicio5 == hiloEjecucion){
			ejeuctarHiloServicio5();
			liberarEjecucion();
		}
	}

	private void liberarEjecucion() {
		try {
			semaphore.liberar();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private void ejecutarHiloServicio4() {
		boolean runHilo4 = true;
		int i = 1;
		while(runHilo4){
			try {
				Thread.sleep(1000);

				System.out.println("Resultado = "+ valorEntrada +"*"+i+" = "+ valorEntrada*i);

				if(i == 15){
					runHilo4 = false;
					i = 0;
				}
				i++;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void ejeuctarHiloServicio5() {
		int j = 0;
		boolean runHilo5 = true;
		while(runHilo5){
			try {
				Thread.sleep(1200);
				valorEntrada = valorEntrada + valorEntrada;
				System.out.println("Resultado modificado = "+ valorEntrada);
				if(j == 15){
					runHilo5 = false;
					j = 0;
				}
				j++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
