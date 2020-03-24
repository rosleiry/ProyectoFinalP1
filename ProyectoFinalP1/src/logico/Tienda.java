package logico;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public Pedido buscarPedidobyID(int ID) {
		
		boolean encontrado = false;
		Iterator<Pedido> i = pedidos.iterator();
		Pedido aux = null;
		
		while(!encontrado && i.hasNext()) {
			aux = i.next();
			if(aux.getIDpedido() == ID)
				encontrado = true;
		}
		return aux;
	}
	
	public Usuario buscarUsuariobyNombre(String nombre) {
		
		boolean encontrado = false;
		Iterator<Usuario> i = usuarios.iterator();
		Usuario aux = null;
		
		while(!encontrado && i.hasNext()) {
			aux = i.next();
			if(aux.getNombre().equalsIgnoreCase(nombre))
				encontrado = true;
		}
		return aux;
	}
	
	public Usuario buscarUsuariobyCedula(String cedula) {
		
		boolean encontrado = false;
		Iterator<Usuario> i = usuarios.iterator();
		Usuario aux = null;
		
		while(!encontrado && i.hasNext()) {
			aux = i.next();
			if(aux.getCedula().equalsIgnoreCase(cedula))
				encontrado = true;
		}
		return aux;
	}
}
