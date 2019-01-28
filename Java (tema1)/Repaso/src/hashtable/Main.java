package hashtable;

import java.util.Enumeration;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		
		Hashtable<String, Usuario> usuarios = new Hashtable<String, Usuario>(); 
		
		usuarios.put("001", new Usuario("001", "Primero"));
		usuarios.put("002", new Usuario("002", "Segundo"));
		usuarios.put("003", new Usuario("003", "Tercero"));
		usuarios.put("004", new Usuario("004", "Cuarto"));
		usuarios.put("005", new Usuario("005", "Quinto"));
		usuarios.put("006", new Usuario("006", "Sexto"));
		usuarios.put("007", new Usuario("007", "Septimo"));
		usuarios.put("008", new Usuario("008", "Octavo"));
		usuarios.put("009", new Usuario("009", "Noveno"));
		usuarios.put("010", new Usuario("010", "Decimo"));
		
		Enumeration<Usuario> enumUsuario = usuarios.elements(); 
		
		System.out.println("\nCon un while loop, utilizando Enumeration: \n");
		System.out.println("ID" + "\t" + "Usuario\n"
				+ "---------------------------------------");
		while(enumUsuario.hasMoreElements()) {
			System.out.println(enumUsuario.nextElement().getIdUsuario() + "\t" 
						+ enumUsuario.nextElement().getNombreUsuario());
		}
	
		System.out.println("\nCon un foreach loop utilizando un objeto Usuario y usuario.values(): \n");
		for (Usuario u : usuarios.values()) {
			System.out.println("Nombre de usuario: " + u.getNombreUsuario()
			 					+ "\t ID: " + u.getIdUsuario());
		}
		
	}
	
	
}
