package hashTable;

import java.util.ArrayList;

import hashTable.HashEntry;

public class HashTable <T extends Comparable<T>, E > {
	
	private int size = 128;
	private int cantValActivos  = 0 ;
	private int cantValTotal = 0;
	private ArrayList< HashEntry<T,E> > hashTable;
	
	/***************************************************************/
	//FUNCIONES AUXILIARES
	
	private int index (int a , int b){
		a =  a < 0 ? -1*a : a;
		return a % b;
	}
	
	private boolean hayMuchos ( int n){
		return n > size*0.75;
	}
	
	private void agrandarHash(){
		System.out.println("ESTOY AGRANDANDO LA TABLA");
	//	size = size  * 2;
		cantValActivos = 0 ;
		cantValTotal = 0;
		ArrayList <HashEntry <T,E> >  hashTable2 = new ArrayList<HashEntry<T,E>>(size);
		for(int i = 0; i < size ; i ++ ){
			if(hashTable.get(i).isValid() == false) hashTable2.add(new HashEntry <T,E>());
			else hashTable2.add(new HashEntry <T,E>(hashTable.get(i).getKey(), hashTable.get(i).getValue()));
		}
		int sizeViejo = size;
		size = size* 2;
		hashTable = new ArrayList<HashEntry<T,E>>(size);
		for(int i = 0 ; i < size; i ++) hashTable.add(new HashEntry<T,E>());
		
		for(int i = 0; i < sizeViejo ; i++){
			if(hashTable2.get(i).isValid() && hashTable2.get(i).isDeleted() == false){
				T key = hashTable2.get(i).getKey();
				Set(key, hashTable2.get(i).getValue());
			}
		}
	}
	
	
	private boolean hayMuyPocos(int a){
		return a < size * 0.5;
	}
	
	private void achicarHash(){
		System.out.println("ACHICANDO TABLA");
		cantValActivos = 0;
		cantValTotal = 0;
		
		//COPIO LA TABLA DE HASH EN HASHTABLE2
		ArrayList <HashEntry <T,E> >  hashTable2 = new ArrayList<HashEntry<T,E>>(size);
		for(int i = 0; i < size ; i ++ ){
			if(hashTable.get(i).isValid() == false) hashTable2.add(new HashEntry <T,E>());
			else hashTable2.add(new HashEntry <T,E>(hashTable.get(i).getKey(), hashTable.get(i).getValue()));
		}
		int sizeOriginal = size;
		size = ((int)(size * 0.75));
		hashTable = new ArrayList<HashEntry<T,E>>(size);
		for(int i = 0 ; i < size; i ++) hashTable.add(new HashEntry<T,E>());
		
		for(int i = 0; i < sizeOriginal ; i++){
			if(hashTable2.get(i).isValid() && hashTable2.get(i).isDeleted() == false){
				T key = hashTable2.get(i).getKey();
				Set(key, hashTable2.get(i).getValue());
			}
		}
		
		
	}
	
	/***************************************************************/
	//FUNCIONES PUBLICAS (INTERFAZ)
	
	public HashTable(){
		hashTable = new ArrayList<HashEntry<T,E>>(size);
		for(int i = 0; i < size; i ++){			
			hashTable.add(new HashEntry<T,E>());
		}
	}
	
	public void Set(T key, E value){
		cantValActivos ++;
		cantValTotal++;
		if(hayMuchos(cantValTotal)){
			agrandarHash();
		}
		int index = this.index(key.toString().hashCode(), size);
	
		while(hashTable.get(index).isValid ()== true) {
			//System.out.println("HUBO COLISION CON KEY = " + key + " ");
			index++;
			index = index % size;
		}
		hashTable.set(index, new HashEntry<T,E>(key, value));
	}
	
	public void Delete (T key){
		cantValActivos--;
		if(hayMuyPocos(cantValActivos) && size > 128){
			achicarHash();			
		}
		int index = this.index(key.toString().hashCode(), size);
		while(hashTable.get(index).isValid () && key.equals(hashTable.get(index).getKey()) == false) {
			index++;
			index = index % size;
		}
		hashTable.get(index).delete();
	}
	public E valueOf (T key){
		int index = this.index(key.toString().hashCode(), size);
		
		while(key.equals(hashTable.get(index).getKey()) == false ) {
			//System.out.println("HUBO COLISION CON KEY = " + key + " ");
			index++;
			index = index % size;
		}
		return hashTable.get(index).getValue();
		
	}
	
	@Override 
	public String toString(){
		StringBuffer res = new StringBuffer();
		res.append("{ ");
		for(int i = 0; i < size; i ++){
			res.append(hashTable.get(i).toString() + ", " );
		}
		res.append("}");
		
		return res.toString();
	}
	
	public int capacity(){
		return size;
	}
	

}
