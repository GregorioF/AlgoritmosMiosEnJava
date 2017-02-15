package hashTable;

public class  HashEntry <T extends Comparable<T> , E > {
	
	private T key;
	private E value;
	private boolean isValid = false;
	
	private boolean isDeleted= false;
	
	public HashEntry(){
	
	}
	
	public HashEntry(T a, E b){
		key = a;
		value = b;
		isDeleted  = false;
		isValid = true;
	}
	
	public boolean isDeleted(){
		return isDeleted;
	}
	public boolean isValid(){
		return isValid;
	}
	
	public void setValue (E b){
		value =b;
	}
	
	public T getKey(){
		return key;
	}
	public E getValue ( ){
		return value;
	}
	
	public void delete(){
		isDeleted = true;
	}
	
	@Override
	public String toString(){
		if( isDeleted) return "Deleted";
		else if( isValid == false ) return "null";
		else return "(key: " + key.toString() + ", value: " + value.toString()+")";  
	}

}
