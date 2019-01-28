package actividad.java;

public class Producto implements Paginable {

	private String Id; 
	private String price; 
	
	public Producto(String productId, String productPrice) {
		this.Id = productId; 
		this.price = productPrice; 
	}

	@Override
	public String getId() {
		return this.Id; 
	}; 
	
	
	@Override
	public String getPrice() {
		return this.price;
	}

	public void setId(String productId) {
		this.Id = productId;
	}

	public void setPrice(String productPrice) {
		this.price = productPrice;
	}

	@Override
	public int paginar(int numElementos, int capacidadPagina, MyCollection orderedCollection) {
		
		int pagina = 1; 
		
		if(MyArrayList.class.equals(orderedCollection)) {
			
//			MyArrayList p = ((MyArrayList) orderedCollection); 
//			for (Object elemento : p) {
//				
//			}
			
			return pagina; 
			
		} else if(MyHashTable.class.equals(orderedCollection)) {
		
			
			
			return pagina; 
			
		} else {
		
			
			
			return pagina; 
		}
		
//		for(Object element : orderedCollection.) {
//			
//		}
	}
	
	/**
	 * Devuelve el menor de los dos elementos, comparando por precio. 
	 */
	@Override
	public Paginable compararPaginables(Paginable p1, Paginable p2) {
		if(Double.parseDouble(p1.getPrice()) < Double.parseDouble(p2.getPrice()) ) {
			return p1; 
		} else {
			return p2; 
		}
	}

	
	
}
