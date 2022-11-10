package day5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoD_array {

		public static void main(String[] args) {
			int[][] marks = {
					{60,90,100,90,50},
					{90,100,89,100,100},
					{40,50,34,20,49},
			};
			
			for(var r = 0 ; r<3; r++) {//loop for row
				for(var c=0; c<5;c++) {//loop for col
					System.out.print(marks[r][c] + "\t");
				}
				System.out.println();
			}
			
			//foreach
			System.out.println("00000000000000000");
			
			for(int[] row : marks) { // loop for row
				for(int col : row) {
					System.out.print(col +"\t");
				}
				System.out.println();
			}
			System.out.println("marks: " + Arrays.deepToString(marks));
		}
}
