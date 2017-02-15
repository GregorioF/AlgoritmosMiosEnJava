package prueba;

import hashTable.*;

 class Hola {
	public String a = "0";
	
	public Hola (){
		a = "5";
	}
	public Hola (String s){
		a = s;
	}
	
	@Override
	public String toString(){
		return a;
	}
}

public class prueba {
	
	
	
	public static void main( String [] args){
		HashTable<Integer, Integer> h = new HashTable<Integer, Integer>();
		System.out.println(h);
		for(int i = 0; i < 100; i++){
			Integer key = new Integer(i);
			Integer value = new Integer(i);
			h.Set(key, value);
		}
		
		System.out.println(h);
		System.out.println("la capacidadd es : " + h.capacity());
		
		for (int i = 0; i < 30 ; i ++){
			Integer key = new Integer(i);
			h.Delete(key);
		}
		System.out.println(h);
		System.out.println("la capacidadd es : " + h.capacity());
		
		for(int i = 30 ; i < 100 ; i ++){
		//	System.out.println("hola mundo");
			Integer key = new Integer (i);
			System.out.println("El valor de : " + key + " es " + h.valueOf(key));
		}
		
		
		
	
	}

}
