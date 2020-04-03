package logico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class Tienda implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pedido> pedidosPagados;
	private ArrayList<Pedido> pedidosPendientes;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Componente> componentes;
	private static Tienda tienda = null;
	
	
	public Tienda() {
		super();
		this.pedidosPagados = new ArrayList<Pedido>();
		this.pedidosPendientes = new ArrayList<Pedido>();
		this.usuarios = new ArrayList<Usuario>();
		this.componentes = new ArrayList<Componente>();
	}

	
	public static Tienda getInstance(){
		if(tienda == null){
			tienda = new Tienda();
		}
		return tienda;
	}
	
	public ArrayList<Pedido> getPedidosPendientes() {
		return pedidosPendientes;
	}


	public void setPedidosPendientes(ArrayList<Pedido> pedidosPendientes) {
		this.pedidosPendientes = pedidosPendientes;
	}


	public static Tienda getTienda() {
		return tienda;
	}


	public static void setTienda(Tienda tienda) {
		Tienda.tienda = tienda;
	}


	public ArrayList<Pedido> getPedidosPagados() {
		return pedidosPagados;
	}


	public void setPedidosPagados(ArrayList<Pedido> pedidosPagados) {
		this.pedidosPagados = pedidosPagados;
	}


	public ArrayList<Pedido> getPedidosEnDeuda() {
		return pedidosPendientes;
	}


	public void setPedidosEnDeuda(ArrayList<Pedido> pedidosPendientes) {
		this.pedidosPendientes = pedidosPendientes;
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
	
		if(nuevoPedido.getEstadoPedido().equalsIgnoreCase("Pagado")) {
			pedidosPagados.add(nuevoPedido);
			guardarDatos();
		} else if(nuevoPedido.getEstadoPedido().equalsIgnoreCase("Pendiente")) {
			pedidosPendientes.add(nuevoPedido);
			guardarDatos();
		}	
		
	}
	
	
	public void agregarUsuario(Usuario nuevoUsuario) {
			usuarios.add(nuevoUsuario);
			guardarDatos();
	}
	
	public void agregarComponente(Componente nuevoComponente) {
		
		Componente c = buscarComponentebySerial(nuevoComponente.getNumSerie());
		
		if(c == null)
			componentes.add(nuevoComponente);
		else
			c.setCantDisponible(c.getCantDisponible() + nuevoComponente.getCantDisponible());
	}
	
	
	public void hacerPedido() {
		
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
		Iterator<Pedido> i = pedidosPagados.iterator();
		Pedido aux = null;
		
		while(!encontrado && i.hasNext()) {
			aux = i.next();
			if(aux.getIDpedido() == ID)
				encontrado = true;
		}
		
		i = pedidosPendientes.iterator();
		
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
		try {
			FileInputStream input = new FileInputStream("Data/Tienda.dat");
			ObjectInputStream inputTienda = new ObjectInputStream(input);
			
			Tienda aux = (Tienda) inputTienda.readObject();
			Tienda.setTienda(aux);
			
			inputTienda.close();
			input.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Clase no encontrada");
		} catch(FileNotFoundException e) {
			guardarDatos();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void guardarDatos() {
		
		try {	
			 FileOutputStream output = new FileOutputStream("Data/Tienda.dat");
			 ObjectOutputStream outputTienda = new ObjectOutputStream(output);
			  
			 outputTienda.writeObject(tienda);
				
			 outputTienda.close();
			 output.close();
		
		}catch (FileNotFoundException e) {
			System.out.println("Error: Archivo no Encontrado");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
	
	
