package app;

import circularList.circularList;

public class App {
	public static void main(String[] args) {
		circularList<String> names = new circularList<String>();

		names.addFirst("Jalil");
		names.addFirst("Andrik");
		names.addLast("Andrea");
		names.addFirst("Abraham");
		names.addFirst("Maria");
		names.addLast("Angela");
		
		
		
		names.pronter();
		
		
		System.out.println();
		System.out.println("Primer nodo: "+names.getFirst().getValue());
		System.out.println("Ultimo nodo: "+names.getLast().getValue());
		
		System.out.println("Lista vacia? "+names.isEmpty());
		
		names.remove("Andrik");
		
		names.removeFirst();
		names.removeLast();
		
		names.removeAfter("Adrea");
		names.removeBefore("Jalil");

		names.AddAfter("Andrea", "Frodo");
		names.AddBefore("Jalil", "Hiram");
		names.replace("Andrea", "Ana");
		
		System.out.println();
		names.pronter();
		System.out.println();
		System.out.println("Indice de Ana: ");
		names.indexOf("Ana");
		
		System.out.println("Tamaño de la lista: ");
		names.size();
		
		names.clear();
		System.out.println();
		System.out.println("Lista vacia? "+names.isEmpty());
		
		
		
	}
}
