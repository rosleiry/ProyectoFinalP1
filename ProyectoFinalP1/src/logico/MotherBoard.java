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
	private String conexionHD;
	
	
	public MotherBoard(int cantDisponible, float precioComp, String marca, String tipoSocket, String modelo, String tipoMemoriaRam, String conexionHD) {
		super(cantDisponible, precioComp, marca);
		this.tipoSocket = tipoSocket;
		this.modelo = modelo;
		this.tipoMemoriaRam = tipoMemoriaRam;
		this.conexionHD = conexionHD;
	}

	

	public String getConexionHD() {
		return conexionHD;
	}



	public void setConexionHD(String conexionHD) {
		this.conexionHD = conexionHD;
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
}
