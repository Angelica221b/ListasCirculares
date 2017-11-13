package circularList;

import node.node;

public class circularList<T> {
	private node<T> sentinel = null;
	private node<T> actual = null;

	public circularList() {
		sentinel = new node<T>();
		actual = new node<T>();
		sentinel.setIndex(-1);
		actual.setIndex(-1);
	}

	public circularList(T value) {
		this();
		sentinel.setNext(new node<T>(value));
		actual = sentinel.getNext();
		sentinel.getNext().setNext(actual);
	}

	public boolean isEmpty() {
		return (sentinel.getNext() == null) ? true : false;
	}

	public node<T> getLast() {
		node<T> tmp = sentinel.getNext();
		if (!isEmpty()) {
			while (!sentinel.getNext().equals(tmp.getNext()))
				tmp = tmp.getNext();
			return tmp;
		}
		return null;
	}
	
	public void pronter() {
		node<T> tmp = sentinel.getNext();
		if(!isEmpty()){
			while(!tmp.getNext().equals(sentinel.getNext())){
				System.out.println(tmp.getValue());
				tmp = tmp.getNext();
			}
			System.out.println(tmp.getValue());
		}else{
			System.out.println();
		}
	}

	public void addFirst(T value) {
		node<T> nuevo = new node<T>(value),last = getLast();		
		if(isEmpty()){
			sentinel.setNext(nuevo);
			nuevo.setNext(nuevo);
		}else{
			nuevo.setNext(sentinel.getNext());
			sentinel.setNext(nuevo);
			last.setNext(nuevo);
		}
		
		
	}

	public node<T> Search(T value) {
		return (!isEmpty()) ? Search(value, sentinel.getNext()) : null;
	}

	public node<T> Search(T value, node<T> list) {
		if (list.getNext().getValue().equals(value)) {
			return list.getNext();
		}
		if (list.getNext().equals(sentinel.getNext())) {
			return null;
		}
		return Search(value, list.getNext());
	}
	
	/////////////////Metodos restantes///////////////////
	
	
	
	//Obtener primer nodo
	public node<T>getFirst(){
		node<T> tmp = sentinel;
		if (!isEmpty()) {
			tmp = tmp.getNext();
			return tmp;
		}
		
			return null;
	}
	
	//Agregar al final
		public void addLast(T value){
			node<T> nuevo = new node<T>(value),last = getLast();		
			if(isEmpty()){
				sentinel.setNext(nuevo);
				nuevo.setNext(nuevo);
			}else{
				last.setNext(nuevo);
				
				nuevo.setNext(getFirst());
			}
		}
		
		
		//Agregar despues
		public boolean AddAfter(T value, T newvalue) {
			node<T> finder = Search(value); //busca el valor
			if(finder != null)
				return AddAfter(new node<T>(newvalue),finder);
			else
				return false;//no lo encontro
		}
		
		public boolean AddAfter(T value,node<T> nodo) {
			node<T> find = Search(value);
			if(find!=null)
				return AddAfter(nodo,find);//agrega el nodo
			else
				return false;
		}
		private boolean AddAfter(node<T> nodo, node<T> list) {
			nodo.setNext(list.getNext());
			list.setNext(nodo);
			
			return true;
		}
		
		//Agregar antes
		public boolean AddBefore(T value, T newvalue) {
			node<T> tmp = sentinel.getNext();
			node<T> find = Search(value);
			
			if(find!=null){
				while(tmp.getNext() != find){
					tmp=tmp.getNext();	
				}
				tmp.setNext(new node<T>(newvalue));
				tmp.getNext().setNext(find);
				
			}
			
			return false;
		}
		
		
	//Remover
		public boolean remove(T value){
			node <T> tmp= sentinel.getNext();
			node<T> find = Search(value);
			reindex();
			if(find != null){
				if(find==getFirst()){
					sentinel.setNext(tmp.getNext());
				}
				if(find.getNext()!=find){
					while(tmp.getNext()!=find){
						tmp=tmp.getNext();
						
					}
					tmp.setNext(find.getNext());
				
				}else{
					sentinel.setNext(null);;
				}
				
			}
			
			return false;
		}
		
		//reindexar
		public void reindex() {
			node<T> tmp=sentinel.getNext();
			int cont=0;
			while(!tmp.getNext().equals(sentinel.getNext())){
				tmp=tmp.getNext();
				tmp.setIndex(++cont);
			}
		}
		
		//remover primero
		public boolean removeFirst(){
			
			if(!isEmpty()){
				return remove(getFirst().getValue());
			}
				return false;
		}
		
		//remover ultimo
		public boolean removeLast(){
			if(!isEmpty()){
				return remove(getLast().getValue());
			}
				return false;
		}
		
		//remover despues
		public boolean removeAfter(T value){
			node<T> find = Search(value);
			
			if(find != null){
				return remove(find.getNext().getValue());
			}
			return false;
		}
		
		//remover antes
		public boolean removeBefore(T value){
			node<T> find = Search(value);
			node<T> tmp = sentinel;
			if(find != null){
				while(tmp.getNext() != find){
					tmp=tmp.getNext();
					
				}
				return remove(tmp.getValue());
			}
			return false;
		}
		
		//remplazar
		public boolean replace(T value, T newvalue){
			node<T> find = Search(value);

			if(find != null){
				return AddAfter(value, newvalue)&&remove(value);
			}
			
			return false;
			
		}
		
		//
		
		public void indexOf(T value){
			node<T> finder = Search(value);
			reindex();
			if(finder!=null){
				System.out.println(finder.getIndex());
			}
			
		}
		
		public void size(){
			reindex();
			System.out.println(getLast().getIndex());
			
		}
		
		public void clear(){
			node<T> tmp = sentinel;
			
			while(!isEmpty()){
				removeFirst();
			}	
		}
}
