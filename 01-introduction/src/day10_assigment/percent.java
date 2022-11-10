package day10_assigment;

import java.text.NumberFormat;

public class percent {

	public static void main(String[] args) {
		NumberFormat per = NumberFormat.getPercentInstance();
		String result = per.format(0.1);
		System.out.println(result);
	}
}
