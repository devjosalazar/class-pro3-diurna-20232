package co.edu.uniquindio.programacion3.productorConsumidor.fabricaTornillos;



public class Fabrica implements Runnable{

	boolean ensamblar = false;
	CajaTornillos cajaTornillos = new CajaTornillos();
	CajaTuercas cajaTuercas = new CajaTuercas();

	ProductorTornillo productorTornillo;
	ProductorTuerca productorTuerca;
	Ensamblador ensamblador;



	@Override
	public void run() {

		ensamblar();

	}

	private void ensamblar() {

		productorTornillo = new ProductorTornillo(cajaTornillos);
		productorTuerca = new ProductorTuerca(cajaTuercas);
		ensamblador = new Ensamblador(cajaTornillos,cajaTuercas);
		ensamblador.setEnsamblar(true);

		productorTornillo.start();
		productorTuerca.start();
		ensamblador.start();

	}

	public boolean isEnsamblar() {
		return ensamblar;
	}

	public void ensamblar(boolean ensamblar) {
		this.ensamblar = ensamblar;
	}

	public void finalizarEnsamble() {
		//		productorTornillo.finalizar();
		//		productorTuerca.finalizar();
		ensamblador.setEnsamblar(false);
		this.ensamblar = false;
	}




}
