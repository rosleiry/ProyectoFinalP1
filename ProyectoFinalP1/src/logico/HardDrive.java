package logico;

public class HardDrive extends Componente{

	private String modelo;
	private int capacidadAl;
	private String tipoConexion;
	
	
	public HardDrive(int cantDisponible, int numSerie, float precioComp, String marca, String modelo, int capacidadAl, String tipoConexion) {
		super(cantDisponible, numSerie, precioComp, marca);
		this.modelo = modelo;
		this.capacidadAl = capacidadAl;
		this.tipoConexion = tipoConexion;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getCapacidadAl() {
		return capacidadAl;
	}


	public void setCapacidadAl(int capacidadAl) {
		this.capacidadAl = capacidadAl;
	}


	public String getTipoConexion() {
		return tipoConexion;
	}


	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
	
	
	

}
