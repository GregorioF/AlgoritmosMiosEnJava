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
		for(int i = 0; i < 64; i++){
			Integer key = new Integer(i);
			Integer value = new Integer(i);
			h.Set(key, value);
		}
		
		System.out.println(h);
	
	}

}
