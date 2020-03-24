package logico;

import java.util.ArrayList;

public class Tienda {

	
	private ArrayList<Pedido> pedidos;
	private ArrayList<Usuario> usuarios;
	
	public Tienda() {
		super();
		this.pedidos = new ArrayList<Pedido>();
		this.usuarios = new ArrayList<Usuario>();
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void agregarPedido(Pedido nuevoPedido) {
		pedidos.add(nuevoPedido);
	}
	
	public void agregarUsuario(Usuario nuevoUsuario) {
		usuarios.add(nuevoUsuario);
	}
	
	
}
