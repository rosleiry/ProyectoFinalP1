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

	
	private ArrayList<Pedido> pedidos;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Componente> componentes;
	private static Tienda tienda;
	
	public Tienda() {
		super();
		this.pedidos = new ArrayList<Pedido>();
		this.usuarios = new ArrayList<Usuario>();
		this.componentes = new ArrayList<Componente>();
	}

	public static Tienda getInstance(){
		if(tienda == null){
			tienda = new Tienda();
		}
		return tienda;
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
		try {
			cargarDatosComponentes();
			cargarDatosUsuarios();
			cargarDatosPedidos();
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Clase no encontrada");
		} catch(FileNotFoundException e) {
			System.out.println("Error: Archivo no encontrado");
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

	private void cargarDatosPedidos() throws IOException, ClassNotFoundException {
		File archivoPedidos = new File("pedidos.dat");
		FileInputStream input = new FileInputStream(archivoPedidos);
		ObjectInputStream inputPedidos = new ObjectInputStream(input);		
	
		try {
			while(true) {
				Pedido aux = (Pedido) inputPedidos.readObject();
				agregarPedido(aux);
			}
		}catch(EOFException e) {}
		
		inputPedidos.close();
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
			guardarDatosPedidos();
		} catch (FileNotFoundException e) {
			System.out.println("Error: Archivo no Encontrado");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void guardarDatosPedidos() throws IOException, FileNotFoundException  {
		File archivoPedidos = new File("pedidos.dat");
		FileOutputStream output = new FileOutputStream(archivoPedidos);
		ObjectOutputStream outputPedidos = new ObjectOutputStream(output);
		
		for(Pedido p : pedidos) {
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
