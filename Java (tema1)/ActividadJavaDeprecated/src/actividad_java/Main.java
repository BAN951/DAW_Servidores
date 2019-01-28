package actividad_java;

import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		
		/*Coleccion c = new MyArrayList();
		c.add(new Producto(x, x, x, ));*/
		
		Producto p1 = new Producto("1", "12.02"); 
		Producto p2 = new Producto("2", "2.00"); 
		Producto p3 = new Producto("3", "9.95"); 
		Producto p4 = new Producto("4", "15.11"); 
		Producto p5 = new Producto("5", "12.02"); 
//		Producto p6 = new Producto(6, 12.02); 
//		Producto p7 = new Producto(7, 12.02); 
//		Producto p8 = new Producto(8, 12.02); 
//		Producto p9 = new Producto(9, 12.02); 
//		Producto p10 = new Producto(10, 12.02); 
//		Producto p11 = new Producto(11, 12.02); 
//		Producto p12 = new Producto(12, 12.02); 
//		Producto p13 = new Producto(13, 12.02);
//		Producto p14 = new Producto(15, 12.02); 
//		Producto p15 = new Producto(16, 12.02); 
		
//		Object o = new ArrayList<Producto>();
//		((ArrayList<Producto>) o).add(p1); 
//		
//		System.out.println(((ArrayList<Producto>) o).get(0).getPrice());
//		
//		Object o1 = new Hashtable<>(); 
//		((Hashtable<Integer, Producto>) o1).put(p1.getId(), p1); 
//		
//		System.out.println(((Hashtable<Integer, Producto>) o1));
		
		MyCollection c = new MyArrayList();
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		
		
		
		
		
		

	}
	
}
