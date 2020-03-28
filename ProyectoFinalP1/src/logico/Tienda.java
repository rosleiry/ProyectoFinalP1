package logico;

import java.util.ArrayList;
import java.util.Iterator;

public class Tienda {

	
	private ArrayList<Pedido> pedidos;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Componente> componentes;
	
	public Tienda() {
		super();
		this.pedidos = new ArrayList<Pedido>();
		this.usuarios = new ArrayList<Usuario>();
		this.componentes = new ArrayList<Componente>();
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
	
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	
	public void agregarPedido(Pedido nuevoPedido) {
		pedidos.add(nuevoPedido);
	}
	
	public void agregarUsuario(Usuario nuevoUsuario) {
		usuarios.add(nuevoUsuario);
	}
	
	public void agregarComponente(Componente nuevoComponente) {
		componentes.add(nuevoComponente);
	}
	
	
	public Componente buscarComponentebySerial(int numSerial) {
		
		boolean encontrado = false;
		Iterator<Componente> i = componentes.iterator();
		Componente aux = null;
		
		while(!encontrado && i.hasNext()) {
			aux = i.next();
			if(aux.getNumSerie() == numSerial)
				encontrado = true;
		}
		return aux;
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
	
	
	public void cargarDatos() {
		
	}
}
