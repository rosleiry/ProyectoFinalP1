package logico;

import java.util.ArrayList;

public class Pedido {

	
	private ArrayList<Componente> componentes;
	private float precioPedido;
	private String cedulaUsuario;
	private int IDpedido;
	private float precioManodeObra;
	
	public Pedido(String cedulaUsuario, int iDpedido, float precioManodeObra) {
		super();
		this.componentes = new ArrayList<Componente>();
		this.precioPedido = 0;
		this.cedulaUsuario = cedulaUsuario;
		this.IDpedido = iDpedido;
		this.precioManodeObra = precioManodeObra;
	}
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	public float getPrecioPedido() {
		return precioPedido;
	}
	public void setPrecioPedido(float precioPedido) {
		this.precioPedido = precioPedido;
	}
	public String getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public int getIDpedido() {
		return IDpedido;
	}
	public void setIDpedido(int iDpedido) {
		IDpedido = iDpedido;
	}
	public float getPrecioManodeObra() {
		return precioManodeObra;
	}
	public void setPrecioManodeObra(float precioManodeObra) {
		this.precioManodeObra = precioManodeObra;
	}
	
	
}
