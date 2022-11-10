package day5;

import java.util.Arrays;

public class Array_Testing {
	public static void main(String[] args) {
		int[] arr1= {
				100,20,200,40,90
		};
		
		//copy
		int[] arr2=Arrays.copyOf(arr1, arr1.length);
		System.out.println("Arr2: " + Arrays.toString(arr2));
		
		int[] arr3=Arrays.copyOfRange(arr1, 1, 3);
		System.out.println("Arr3: " +Arrays.toString(arr3));
		
		//verify two arrays are equal
		System.out.println("arr1==arr3  : " + Arrays.equals(arr1, arr3));
		
		//sort
		Arrays.sort(arr1);
		System.out.println("After sorting,Arr1: "+ Arrays.toString(arr1));
		
		//search
		System.out.println("Is 90 in arr1: " + Arrays.binarySearch(arr1, 90)) ;
		System.out.println("Is 900 in arr1: "+ Arrays.binarySearch(arr1, 900));
		
		//fill
		Arrays.fill(arr1, 10);
		System.out.println("After filling 10,arr1: " + Arrays.toString(arr1));
		
		//using with Stream Api
		int total = Arrays.stream(arr2).sum();
		System.out.println("Total: " + total);
		System.out.println("Max: " + Arrays.stream(arr2).max().getAsInt());
	}
}
