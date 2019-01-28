package actividad.java;

import java.util.LinkedHashMap;

public class MyLinkedHashMap extends MyCollection {

	LinkedHashMap<String, Paginable> p; 
	
	public MyLinkedHashMap() {
		p = new LinkedHashMap<String, Paginable>(); 
	}

	@Override
	public void add(Paginable paginable) {
		p.put(paginable.getId(), paginable); 
		
	}

	@Override
	public boolean remove(Paginable paginable) {
		for (Object elemento :  p.values()) {
			if(((Paginable) elemento).getId() == paginable.getId()) {
				p.remove(((Paginable) elemento).getId()); // Se utiliza la key del Hashtable en el remove, borra según la key. 
				return true; 
			}
		}
		return false;
	}

	@Override
	public boolean contains(Paginable paginable) {
		if(p.containsKey(paginable.getId()))
			return true; 
		else 
			return false;
	}

	@Override
	public void printID() {
		for (Object elemento : p.values()) {
			System.out.println("ID : " + ((Paginable) elemento).getId());
		}
		
	}

}
