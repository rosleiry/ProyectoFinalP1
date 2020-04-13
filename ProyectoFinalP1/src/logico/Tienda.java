package logico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;


public class Tienda implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pedido> pedidos  = new ArrayList<Pedido>();;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Componente> componentes;
	private static Tienda tienda = null;
	private int serialComponente = 1;
	private int IDpedido = 1;
	
	
	public Tienda() {
		
		this.usuarios = new ArrayList<Usuario>();
		this.componentes = new ArrayList<Componente>();
		
	}

	
	public int getSerialComponente() {
		return serialComponente;
	}


	public void setSerialComponente(int serialComponente) {
		this.serialComponente = serialComponente;
	}


	public int getIDpedido() {
		return IDpedido;
	}


	public void setIDpedido(int iDpedido) {
		this.IDpedido = iDpedido;
	}


	public static Tienda getInstance(){
		if(tienda == null){
			tienda = new Tienda();
		}
		return tienda;
	}
	
	


	public static Tienda getTienda() {
		return tienda;
	}


	public static void setTienda(Tienda tienda) {
		Tienda.tienda = tienda;
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
	
		nuevoPedido.setIDpedido(IDpedido);
		this.pedidos.add(nuevoPedido);
		IDpedido++;
		guardarDatos();
		
	}
	
	
	public void agregarUsuario(Usuario nuevoUsuario) {
			usuarios.add(nuevoUsuario);
			guardarDatos();
	}
	
	public void agregarComponente(Componente nuevoComponente) {
		
		nuevoComponente.setNumSerie(serialComponente);
		componentes.add(nuevoComponente);
		serialComponente++;
		guardarDatos();
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
		
		i = pedidos.iterator();
		
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

	public void cargarDatos2() {
		try {
			FileInputStream input = new FileInputStream("Data/respaldo.txt");
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
	
	public void guardarDatos2() {
		
		try {	
			 FileOutputStream output = new FileOutputStream("Data/respaldo.txt");
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
	
	public int getCantComponentes() {
		int total = 0;
		
		for(Componente c : componentes){
			total += c.getCantDisponible();
		}
		return total;
	}
	
	public ArrayList<Componente> ordenarComponentesHightoLow() {
		
		ArrayList<Componente> aux =	new ArrayList<Componente>();
		aux = (ArrayList<Componente>) this.componentes.stream()
				.sorted(Comparator.comparing(Componente::getPrecioComp).reversed())
				.collect(Collectors.toList());
		
		return aux;
	}
	
	public ArrayList<Componente>  ordenarComponentesLowtoHigh() {
		
		ArrayList<Componente> aux =	new ArrayList<Componente>();
		aux = (ArrayList<Componente>) this.componentes.stream()
				.sorted(Comparator.comparing(Componente::getPrecioComp))
				.collect(Collectors.toList());
		
		return aux;
	}
}
	
	
