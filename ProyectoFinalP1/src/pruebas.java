import logico.Tienda;
import logico.Usuario;

public class pruebas {

	public static void main(String[] args) {
			
			
			Tienda.getInstance().cargarDatos();
			
			System.out.println(Tienda.getInstance().getUsuarios().isEmpty());
			
			Tienda.getInstance().guardarDatos();
	}

}
