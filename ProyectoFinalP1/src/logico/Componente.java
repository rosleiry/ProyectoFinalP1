package logico;

import java.io.Serializable;

public abstract class Componente implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int cantDisponible;
	protected int numSerie;
	protected float precioComp;
	protected String marca;
	
	public Componente(int cantDisponible, float precioComp, String marca) {
		super();
		this.cantDisponible = cantDisponible;
		this.numSerie = 0;
		this.precioComp = precioComp;
		this.marca = marca;
	}
	
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
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
