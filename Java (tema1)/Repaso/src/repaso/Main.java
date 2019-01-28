package repaso;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		Division div = new Division(10, 2); 
		System.out.println(div.operar()); 
		
		Division div2 = new Division(10, 2); 
		System.out.println(div2.operar()); 
		
		System.out.println(div.getNumeroInstancias());
	
		dummy(div); 
		
		System.out.println("-----------------------------------------");
		
		ArrayList<String> array1 = new ArrayList<String>(); 
		 
		array1.add("String1");
		array1.add("String2");
		array1.add("String3");
		array1.add("String4");
		array1.add("String5");
		
		/*Becario. */ 
		for (int i = 0; i < array1.size(); i++) {
			System.out.println(array1.get(i));
		}
		
		/*Me he flipado. */
		Iterator<String> it = array1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		/*No estoy en 2005. */
		System.out.println("\nElementos del array1: \n");
		
		for(String elemento : array1) {
			System.out.println("\t" + elemento);
		}
		
		System.out.println("\nPrinting the whole ArrayList: " + array1);
		
		System.out.println("\nFinished printing...");
		
		/*Manera complicada. */
		System.out.println("\nOperador ternario: ");
		int num = 2;
		String result = num > 0? "Mayor que 0" : "Menor que 0"; 
		System.out.println(result);
		
		/*Manera bien hecha. */
		System.out.println("\n" + (num > 0? "Mayor" : "Menor") + " que 0. ");
		
	}

	public static void dummy(Operable op) {
		System.out.println(op.getClass().toString());
	}
	
}
