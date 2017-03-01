package dobleColaDePrioridad;

import java.util.ArrayList;

public class MaxHeap <T extends Comparable<T>> {
	private int size = 0;
	private int capacidad = 32;
	private ArrayList<Nodo<T>> maxHeap ;
	private ArrayList<Nodo<T>> minHeap;
	
	private boolean hayMuchos(){
		return true;
	}
	private void agrandarTabla(){
		
	}
	private int padre(int n){
		if(n % 2 == 0) return n/2 -1;
		else return n/2;
	}
	
	private int subirMax(int n){
		int res = n;
		Nodo <T> padre = maxHeap.get(padre(n));
		Nodo <T> act = maxHeap.get(n);
		while(padre.getValue().compareTo(act.getValue()) < 0  ){
			res = padre(n);
			maxHeap.set(padre(n), act);
			maxHeap.set(n, padre);
			
			int padreHermano = padre.hermano();
			Nodo<T> padreHermanoNodo = minHeap.get(padreHermano);
			padreHermanoNodo.setHermano(n);
			n = res;
		}
		return res;		
	}
	
	private int subirMin(int n){
		int res = n;
		Nodo <T> padre = minHeap.get(padre(n));
		Nodo <T> act = minHeap.get(n);
		while(padre.getValue().compareTo(act.getValue()) > 0  ){
			res = padre(n);
			minHeap.set(padre(n), act);
			minHeap.set(n, padre);
			
			int padreHermano = padre.hermano();
			Nodo<T> padreHermanoNodo = maxHeap.get(padreHermano);
			padreHermanoNodo.setHermano(n);
			n = res;
		}
		return res;	
		
	}
	
	public MaxHeap(){
		
	}
	public void Add(Nodo<T> n ){
		size++;
		maxHeap.set(size - 1 , n);
		minHeap.set(size - 1, n);
		if (hayMuchos()){ 
			agrandarTabla();
		}
		int posNodo1= subirMax(size -1 );
		int posNodo2 = subirMin(size-1);
		
		Nodo<T> n1 = maxHeap.get(posNodo1);
		Nodo<T> n2 = minHeap.get(posNodo2);
		n1.setHermano(posNodo2);
		n2.setHermano(posNodo1);
		
	}
	
}
