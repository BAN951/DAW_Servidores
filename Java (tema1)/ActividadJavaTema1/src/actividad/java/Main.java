package actividad.java;

public class Main {

	public static void main(String[] args) {
		
//		Producto p1 = new Producto("1", "2");
//		Producto p2 = new Producto("2", "5"); 
//		Producto p3 = new Producto("3", "10"); 
//		
//		MyCollection c = new MyArrayList();
//		c.add(p1);
//		c.add(p2);
//		c.add(p3);
//		
//		c.printID();
//		
//		System.out.println(c.contains(p3));
//		c.remove(p2); 
//		System.out.println(c.contains(p2));
	
		// ---------------------------------------------------------------------
		
//		Producto p1 = new Producto("1", "2");
//		Producto p2 = new Producto("2", "5"); 
//		Producto p3 = new Producto("3", "10"); 
//		
//		MyCollection c = new MyHashTable();
//		c.add(p1);
//		c.add(p2);
//		c.add(p3);
//		
//		c.printID();
//		
//		System.out.println(c.contains(p3));
//		c.remove(p2); 
//		System.out.println(c.contains(p2));
		
		// ---------------------------------------------------------------------
		
		Producto p1 = new Producto("1", "2");
		Producto p2 = new Producto("2", "5"); 
		Producto p3 = new Producto("3", "10"); 
		
		MyCollection c = new MyArrayList();
		c.add(p1);
		c.add(p2);
		c.add(p3);
		
		c.printID();
		
		System.out.println(c.contains(p3));
		c.remove(p2); 
		System.out.println(c.contains(p2));
		
		c.printID();
		
		
		
		
		
	}

}
