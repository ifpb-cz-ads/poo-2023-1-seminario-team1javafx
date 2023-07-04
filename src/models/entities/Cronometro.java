package models.entities;

public class Cronometro {
	private int minutos;
	private int segundos;
	private int milissegundos;
	
	public Cronometro() {
	}
	
	public Cronometro(int minutos, int segundos, int milissegundos) {
		this.minutos = minutos;
		this.segundos = segundos;
		this.milissegundos = milissegundos;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getMilissegundos() {
		return milissegundos;
	}

	public void setMilissegundos(int milissegundos) {
		this.milissegundos = milissegundos;
	}
	
	
}
