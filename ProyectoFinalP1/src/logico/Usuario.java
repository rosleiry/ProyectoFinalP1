package logico;

public class Usuario {

	
	private String nombre;
	private String cedula;
	private String direccion;
	
	public Usuario(String nombre, String cedula, String direccion) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
