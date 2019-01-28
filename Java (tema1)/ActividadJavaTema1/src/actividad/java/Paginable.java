package actividad.java;

public interface Paginable {

	public abstract String getId();
	public abstract String getPrice();
	public int paginar(int numElementos, int capacidadPagina, MyCollection m);  
	public abstract Paginable compararPaginables(Paginable p1, Paginable p2); 
}
