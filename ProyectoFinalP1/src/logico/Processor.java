package logico;

public class Processor extends Componente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modelo;
	private String tipoSocket;
	private float velDelProc;
	
	
	public Processor(int cantDisponible, int numSerie, float precioComp, String marca, String modelo, String tipoSocket, float velDelProc) {
		super(cantDisponible, numSerie, precioComp, marca);
		this.modelo = modelo;
		this.tipoSocket = tipoSocket;
		this.velDelProc = velDelProc;
		
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getTipoSocket() {
		return tipoSocket;
	}


	public void setTipoSocket(String tipoSocket) {
		this.tipoSocket = tipoSocket;
	}


	public float getVelDelProc() {
		return velDelProc;
	}


	public void setVelDelProc(float velDelProc) {
		this.velDelProc = velDelProc;
	}
	
	
	
	

}
