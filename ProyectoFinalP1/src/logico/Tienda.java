package logico;

import java.util.ArrayList;

public class Tienda {

	
	private ArrayList<Pedido> pedidos;
	private ArrayList<componente> componentes;
	
	public Tienda() {
		super();
		this.pedidos = new ArrayList<Pedido>();
		this.componentes = new ArrayList<Componentes>();
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<componente> componentes) {
		this.componentes = componentes;
	}
	
	
}
