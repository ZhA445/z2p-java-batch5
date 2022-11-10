package day12.HasA;

import java.time.LocalDate;

public class Demo2 {
	public static void main(String[] args) {
		SaleRecord[] records = new SaleRecord[3];
		
		var prod1 = new Product("coffee", 1500);
		var prod2  = new Product("Juice", 2000);
		
		records[0] = new SaleRecord(1001, LocalDate.now(), prod1, 10);
		records[1] = new SaleRecord(1002, LocalDate.now().minusDays(1), prod1, 5);
		records[2] = new SaleRecord(1003, LocalDate.now(), prod2, 5);
		
		System.out.println("ID \t Sale Date \t Product \t Qty \t SutTotal");
		System.out.println("------------------------------------");
		for(var i = 0; i<records.length ; i++) {
			records[i].showData();
		}
	}
}
