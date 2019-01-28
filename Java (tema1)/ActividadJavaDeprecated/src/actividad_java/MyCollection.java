package actividad_java;

import java.util.Collection;

public abstract class MyCollection implements Paginable {
	
	protected Object o; 
	
	public abstract void add(Paginable p); 
	
	public abstract void remove(Paginable p);
	
	public abstract boolean contains(Paginable p);
	
	public abstract void printId(); 
	
	public abstract void printPrecios();
	
}
