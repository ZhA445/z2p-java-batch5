package day14;

import java.util.Stack;

public class Stack_Testing {

	public static void main(String[] args) {
		 Stack<String> stack = new Stack<>();
		 
		 stack.push("Orange");
		 stack.push("Apple");
		 stack.push("PipeApple");
		 
		 System.out.println("[0]: " + stack.get(0));
		 
		 //remove
		 stack.pop();//first in last out
		 
		 System.out.println("After remove: " + stack);
		 
	}
}
