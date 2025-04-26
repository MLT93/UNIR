package javabean;

public class Gato extends Animal{
	
	private int numeroVidas;

	public Gato() {
		super();
	}

	

	public Gato(int matricula, String nombreCientifico, int numeroPatas, int numeroVidas) {
		super(matricula, nombreCientifico, numeroPatas);
		this.numeroVidas = numeroVidas;
	}



	public int getNumeroVidas() {
		return numeroVidas;
	}

	public void setNumeroVidas(int numeroVidas) {
		this.numeroVidas = numeroVidas;
	}



	@Override
	public String toString() {
		return "Gato [matricula=" + matricula + ", nombreCientifico=" + nombreCientifico + ", numeroPatas="
				+ numeroPatas + ", numeroVidas=" + numeroVidas + "]";
	}



	@Override
	public void sonido() {
		// TODO Auto-generated method stub
		System.out.println("Soy un Gato y digo MIAUUUU!!");
	}
	
	public void aumentarVidas(int cantidad) {
		numeroVidas  += cantidad;
	}
	
	public void cancelarVidas(int cantidad) {
		if ((numeroVidas - cantidad) <= 0)
			System.out.println("creo que la has palmao");
		else
			numeroVidas -= cantidad;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
