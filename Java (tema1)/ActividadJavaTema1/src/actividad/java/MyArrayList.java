package actividad.java;

import java.util.ArrayList;
import java.util.Collection;

public class MyArrayList extends MyCollection {

	Collection<Paginable> p; 
	
	public MyArrayList() {
		p = new ArrayList<Paginable>(); 
	}

	@Override
	public void add(Paginable paginable) {
		((ArrayList<Paginable>) p).add(paginable); 
		
	}

	@Override
	public boolean remove(Paginable paginable) {
		for (Object elemento : p) {
			if(elemento == paginable) {
				((Collection<Paginable>) p).remove(elemento); 
				return true; // Se ha borrado el elemento con exito
			}
		}
		
		return false; // No se ha borrado el elemento.
	}

	@Override
	public boolean contains(Paginable paginable) {
		if(p.contains(paginable))
			return true; 
		else
			return false; 
	}
	
	@Override
	public void printID() {
		for (Object elemento : p) {
			System.out.println("ID : " + ((Paginable) elemento).getId());
		}
	}
	
}
