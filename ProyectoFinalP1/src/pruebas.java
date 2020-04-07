import logico.Tienda;
import logico.Usuario;

public class pruebas {

	public static void main(String[] args) {
			
			
			Tienda.getInstance().cargarDatos();
			
			/*
			 * Tienda.getInstance().agregarUsuario(new
			 * Usuario("Robert","001","Cerros de Gurabo"));
			 * Tienda.getInstance().agregarUsuario(new
			 * Usuario("Miguel","002","Cerros de Gurabo"));
			 * Tienda.getInstance().agregarUsuario(new
			 * Usuario("Rosleiry","003","Cerros de Gurabo"));
			 */
			
			for(Usuario c : Tienda.getInstance().getUsuarios()) {
				System.out.println(c.toString());
			}
			
			Tienda.getInstance().guardarDatos();
	}

}
