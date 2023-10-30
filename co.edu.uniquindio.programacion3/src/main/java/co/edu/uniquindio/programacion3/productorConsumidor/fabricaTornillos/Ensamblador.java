package co.edu.uniquindio.programacion3.productorConsumidor.fabricaTornillos;

public class Ensamblador extends Thread {
	private CajaTornillos cajaTornillos;
	private CajaTuercas cajaTuercas;

	boolean ensamblar = false;
	public Ensamblador( CajaTornillos cajaTornillos, CajaTuercas cajaTuercas ) {
		this.cajaTornillos = cajaTornillos;	
		this.cajaTuercas = cajaTuercas;
	}



	public boolean isEnsamblar() {
		return ensamblar;
	}



	public void setEnsamblar(boolean ensamblar) {
		this.ensamblar = ensamblar;
	}



	public void run() {

		while(ensamblar){
			String tornillo = "";
			String tuerca = "";
			if(cajaTornillos.hayTornillo && cajaTuercas.hayTuerca)
			{
				tornillo = cajaTornillos.getTornillo();
				tuerca = cajaTuercas.getTuerca();
				System.out.println("------------------Ensamblando: \n");
				System.out.println("	Tornillo : "+tornillo+"\n");
				System.out.println("	Tuerca : "+tuerca+"\n");
				System.out.println("------------------Ensamble Finalizado: \n");
			}else{
				System.err.println("Esperando tornillo o tuerca");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
}