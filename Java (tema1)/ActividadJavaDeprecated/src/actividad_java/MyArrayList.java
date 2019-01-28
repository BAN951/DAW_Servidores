package actividad_java;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList extends MyCollection {
	
	public MyArrayList() {
		o = new ArrayList<Paginable>();
	}
	
	@Override
	public int paginar(int numeroDePaginas) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void add(Paginable p) {
		((java.util.ArrayList)o).add(p);
		
	}	

	@Override
	public void remove(Paginable p) {
		
		
	}

	@Override
	public boolean contains(Paginable p) {
		// TODO Auto-generated method stub
		
		return false; 
		
	}

	@Override
	public void printId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printPrecios() {
		Iterator<Paginable> it = ((Iterator<Paginable>) o);
		while(it.hasNext()) {
			System.out.println(it.toString());
		}
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
