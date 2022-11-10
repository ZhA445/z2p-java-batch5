package day4;

public class LoopingStatement {

		public static void main(String[] args) {
			String languages[] = {
					"Python","Java","JavaScript"
			};
			
			//for loop
			System.out.println("-----for loop-----");
			for (var i = 0; i< languages.length; i++) {
				System.out.println("language: " + languages[i]);
			}
			
			//while loop
			System.out.println("-----while loop-----");
			int j=0;
			while(j<languages.length) {
				String lang = languages[j];
				System.out.println("language: " + lang);
				j ++;
			}
			//do while loop
			
			System.out.println("-----do while loop-----");
			int k=0;
			do {
				String lang1 = languages[k];
				System.out.println("language: " + lang1);
				k++;
			}while(k<languages.length);
			
			//foreach loop
			System.out.println("-----foreach loop-----");
			for(String lang1 : languages) {
				System.out.println("language: " + lang1);
			};
		}
}
