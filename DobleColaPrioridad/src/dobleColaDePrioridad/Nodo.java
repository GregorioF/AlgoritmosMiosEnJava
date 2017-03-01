package dobleColaDePrioridad;

public class Nodo <T extends Comparable<T>>{
	T value;
	int hermano= 0;
	Nodo<T> izq = null;
	Nodo<T> der = null;
	public Nodo(T value2){
		value = value2;
	}
	public void setIzq(Nodo<T> izq2){
		izq = izq2;
	}
	public void setDer(Nodo<T> der2){
		der = der2;
	}
	public void setHermano(int hermano2){
		hermano = hermano2;
	}
	public T getValue (){
		return value;
	}
	public boolean tieneDosHijos (){
		return izq!=null && der != null;
	}
	public int hermano(){
		return hermano;
	}

}
