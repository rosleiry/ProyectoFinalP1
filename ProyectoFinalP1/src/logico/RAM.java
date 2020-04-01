package logico;

public class RAM extends Componente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantMemoria;
	private String tipoMemoria;
	
	
	public RAM(int cantDisponible, int numSerie, float precioComp, String marca, int cantMemoria, String tipoMemoria) {
		super(cantDisponible, numSerie, precioComp, marca);
		this.cantMemoria = cantMemoria;
		this.tipoMemoria = tipoMemoria;
		
	}


	public int getCantMemoria() {
		return cantMemoria;
	}


	public void setCantMemoria(int cantMemoria) {
		this.cantMemoria = cantMemoria;
	}


	public String getTipoMemoria() {
		return tipoMemoria;
	}


	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	
	
	
	

}
