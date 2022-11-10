package day5;

public class TwoD_OneD {
	public static void main(String[] args) {
		int[][] marks= {
				{60,90,100,90,50},
				{90,100,89,100,100},
				{40,50,34,20,49}
		};
		String[] names= {
				"Jeon","Yuri","Cherry"
		};
		
		for(var i=0; i<names.length;i++) {
			var total=0;
			for(var j=0;j<5;j++) {
				total += marks[i][j];
			}
			
			System.out.println("Total marks obtained by student "+ names[i] + " : "+ total +"  marks");
			System.out.println("Average: " + total/5.0f + "marks");
		}
	}
}
