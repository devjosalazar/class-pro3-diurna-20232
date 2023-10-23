package co.edu.uniquindio.programacion3.hilos_CreacionV2;

public class ManejadorHilo implements  Runnable{

	HiloServicio1 hiloServicio1;
	HiloServicio2 hiloServicio2;
	HiloServicio3 hiloServicio3;

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
		if(hiloServicio4 == hiloEjecucion){
			ejecutarHiloServicio4();
		}

		if(hiloServicio5 == hiloEjecucion){
			ejeuctarHiloServicio5();
		}
	}

	private void ejecutarHiloServicio4() {
		int i = 1;
		while(runHilo){
			try {
				Thread.sleep(700);

				System.out.println("Resultado = "+ valorEntrada +"*"+i+" = "+ valorEntrada*i);

				if(i == 15){
					runHilo = false;
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
		while(runHilo){
			try {
				Thread.sleep(1200);
				valorEntrada = valorEntrada + valorEntrada;
				System.out.println("Resultado modificado = "+ valorEntrada);
				if(j == 15){
					runHilo = false;
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
