package logico;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;


public class Tienda {

	
	private ArrayList<Pedido> pedidosPagados;
	private ArrayList<Pedido> pedidosPendientes;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Componente> componentes;
	private static Tienda tienda;
	
	
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
		
		try {
			if(nuevoPedido.getEstadoPedido().equalsIgnoreCase("Pagado")) {
				pedidosPagados.add(nuevoPedido);
				guardarDatosPedidosPagados();
			} else if(nuevoPedido.getEstadoPedido().equalsIgnoreCase("Pendiente")) {
				pedidosPendientes.add(nuevoPedido);
				guardarDatosPedidosPendientes();
			}	
		} catch (FileNotFoundException e) {
			System.out.println("Error: Archivo no encontrado");
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	
	public void agregarUsuario(Usuario nuevoUsuario) {
		
		try {
			usuarios.add(nuevoUsuario);
			guardarDatosUsuarios();
		} catch (FileNotFoundException e) {
			System.out.println("Error: Archivo no encontrado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			cargarDatosComponentes();
			cargarDatosUsuarios();
			cargarDatosPedidosPendientes();
			cargarDatosPedidosPagados();
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Clase no encontrada");
		} catch(FileNotFoundException e) {
			guardarDatos();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void cargarDatosUsuarios() throws ClassNotFoundException, IOException {
		File archivoUsuarios = new File("Usuarios.dat");
		FileInputStream input = new FileInputStream(archivoUsuarios);
		ObjectInputStream inputUsuarios = new ObjectInputStream(input);
		
		try {
			while(true) {
				Usuario aux = (Usuario) inputUsuarios.readObject();
				agregarUsuario(aux);
			}
		} catch(EOFException e) {}
		
		inputUsuarios.close();
		input.close();
	}

	private void cargarDatosPedidosPagados() throws IOException, ClassNotFoundException {
		File archivoPedidosPagados = new File("pedidospagados.dat");
		FileInputStream input = new FileInputStream(archivoPedidosPagados);
		ObjectInputStream inputPedidosPagados = new ObjectInputStream(input);		
	
		try {
			while(true) {
				Pedido aux = (Pedido) inputPedidosPagados.readObject();
				agregarPedido(aux);
			}
		}catch(EOFException e) {}
		
		inputPedidosPagados.close();
		input.close();
	}
	
	private void cargarDatosPedidosPendientes() throws IOException, ClassNotFoundException {
		File archivoPedidosPendientes = new File("pedidospendientes.dat");
		FileInputStream input = new FileInputStream(archivoPedidosPendientes);
		ObjectInputStream inputPedidosPendientes = new ObjectInputStream(input);		
	
		try {
			while(true) {
				Pedido aux = (Pedido) inputPedidosPendientes.readObject();
				agregarPedido(aux);
			}
		}catch(EOFException e) {}
		
		inputPedidosPendientes.close();
		input.close();
	}

	private void cargarDatosComponentes() throws IOException, ClassNotFoundException {
		File archivoComponentes = new File("componentes.dat");
		FileInputStream input = new FileInputStream(archivoComponentes);
		ObjectInputStream inputComponentes = new ObjectInputStream(input);		
	
		try {
			while(true) {
				Componente aux = (Componente) inputComponentes.readObject();
				agregarComponente(aux);
			}
		}catch(EOFException e) {}
		
		inputComponentes.close();
		input.close();
	}
	
	public void guardarDatos() {
		try {
			guardarDatosComponentes();
			guardarDatosUsuarios();
			guardarDatosPedidosPagados();
			guardarDatosPedidosPendientes();
		} catch (FileNotFoundException e) {
			System.out.println("Error: Archivo no Encontrado");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void guardarDatosPedidosPagados() throws IOException, FileNotFoundException  {
		File archivoPedidosPagados = new File("pedidospagados.dat");
		FileOutputStream output = new FileOutputStream(archivoPedidosPagados);
		ObjectOutputStream outputPedidos = new ObjectOutputStream(output);
		
		for(Pedido p : pedidosPagados) {
			outputPedidos.writeObject(p);
		}
		
		outputPedidos.close();
		output.close();
	}
	
	private void guardarDatosPedidosPendientes() throws IOException, FileNotFoundException  {
		File archivoPedidosPendientes = new File("pedidospendientes.dat");
		FileOutputStream output = new FileOutputStream(archivoPedidosPendientes);
		ObjectOutputStream outputPedidos = new ObjectOutputStream(output);
		
		for(Pedido p : pedidosPendientes) {
			outputPedidos.writeObject(p);
		}
		
		outputPedidos.close();
		output.close();
	}

	private void guardarDatosUsuarios() throws IOException, FileNotFoundException {
		File archivoUsuarios = new File("Usuarios.dat");
		FileOutputStream output = new FileOutputStream(archivoUsuarios);
		ObjectOutputStream outputUsuarios = new ObjectOutputStream(output);
		
		for(Usuario u: usuarios) {
			outputUsuarios.writeObject(u);
		}
		
		outputUsuarios.close();
		output.close();
		
	}

	private void guardarDatosComponentes() throws IOException, FileNotFoundException{
		File archivoComponentes = new File("componentes.dat");
		FileOutputStream output = new FileOutputStream(archivoComponentes);
		ObjectOutputStream outputComponentes = new ObjectOutputStream(output);
		
		for(Componente c : componentes) {
			outputComponentes.writeObject(c);
		}
		
		outputComponentes.close();
		output.close();
	}
}
