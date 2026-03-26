package ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class EjemploDataInputOutput {

	public static void main(String[] args) {
		//ruta
		Path ruta =Path.of("datos.dat");
		//outputStream
		try(OutputStream out=Files.newOutputStream(ruta, StandardOpenOption.CREATE);DataOutputStream dataOut=new DataOutputStream(out);) {
			
			for(int i=0;i<100;i++) {
				dataOut.writeInt(i);
				dataOut.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//leer el archivo

		try(InputStream in=Files.newInputStream(ruta);DataInputStream dataIn=new DataInputStream(in);) {
			int numero;
			while(true) {
				numero=dataIn.readInt();
				System.out.println(numero);
				
			}

		} catch (IOException e) {
			System.out.println("Fin fichero");
		}


	}

}
