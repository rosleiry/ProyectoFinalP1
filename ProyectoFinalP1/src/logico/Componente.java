package logico;

import java.io.Serializable;

public abstract class Componente implements Serializable {

	protected int cantDisponible;
	protected int numSerie;
	protected float precioComp;
	protected String marca;
	
	public Componente(int cantDisponible, int numSerie, float precioComp, String marca) {
		super();
		this.cantDisponible = cantDisponible;
		this.numSerie = numSerie;
		this.precioComp = precioComp;
		this.marca = marca;
	}

	public int getCantDisponible() {
		return cantDisponible;
	}

	public void setCantDisponible(int cantDisponible) {
		this.cantDisponible = cantDisponible;
	}

	public int getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	public float getPrecioComp() {
		return precioComp;
	}

	public void setPrecioComp(float precioComp) {
		this.precioComp = precioComp;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	

}
