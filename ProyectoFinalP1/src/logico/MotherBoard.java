package logico;

import java.util.ArrayList;

public class MotherBoard extends Componente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoSocket;
	private String modelo;
	private String tipoMemoriaRam;
	private ArrayList<Componente> conexionHD;
	
	
	public MotherBoard(int cantDisponible, int numSerie, float precioComp, String marca, String tipoSocket, String modelo, String tipoMemoriaRam) {
		super(cantDisponible, numSerie, precioComp, marca);
		this.tipoSocket = tipoSocket;
		this.modelo = modelo;
		this.tipoMemoriaRam = tipoMemoriaRam;
		this.conexionHD = new ArrayList<Componente>();
	}


	public String getTipoSocket() {
		return tipoSocket;
	}


	public void setTipoSocket(String tipoSocket) {
		this.tipoSocket = tipoSocket;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getTipoMemoriaRam() {
		return tipoMemoriaRam;
	}


	public void setTipoMemoriaRam(String tipoMemoriaRam) {
		this.tipoMemoriaRam = tipoMemoriaRam;
	}


	public ArrayList<Componente> getConexionHD() {
		return conexionHD;
	}


	public void setConexionHD(ArrayList<Componente> conexionHD) {
		this.conexionHD = conexionHD;
	}
	
	

}
