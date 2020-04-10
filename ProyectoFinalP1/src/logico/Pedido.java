package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Componente> componentes;
	private float precioPedido;
	private String cedulaUsuario;
	private int IDpedido;
	
	
	public Pedido(String cedulaUsuario) {
		super();
		this.componentes = new ArrayList<Componente>();
		this.precioPedido = 0;
		this.cedulaUsuario = cedulaUsuario;
		this.IDpedido = 0;
	}
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
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
	
	public void agregarComponente(Componente nuevoComponente) {
		componentes.add(nuevoComponente);
	}
	
	
	
	public float getPrecioPedido() {
		float aux = 0;
		
		for (Componente componente : componentes) {
			aux += componente.getPrecioComp();
		}
		
		return aux;
	}
}
