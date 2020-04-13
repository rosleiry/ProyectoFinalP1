package Socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)  throws UnknownHostException, IOException{
		Socket cliente = new Socket("127.0.0.1",9000);
		
		
		
		ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
		
		FileInputStream file = new FileInputStream("C:/Data/Tienda.dat");
		
		byte[] buf = new byte[4096];
		
		while(true) {
			int len = file.read(buf);
			if(len == -1) break;
			out.write(buf, 0, len);
		}

	}

}
