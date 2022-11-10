package day14;

import java.util.LinkedList;

public class LinkList_Testing {

	public static void main(String[] args) {
		
		LinkedList<String> linklist = new LinkedList<>();
		linklist.add("Nilar");
		linklist.add(0, "Aung Aung");
		linklist.add("Kyaw Kyaw");
		
		System.out.println(linklist);
		
		linklist.addFirst("Honey");
		linklist.addLast("Hla Hla");
		System.out.println(linklist);
		
		System.out.println("[0]: " + linklist.get(0)); 
	}
}
