package day6;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class PeriodAndDuration {

	public static void main(String[] args) {
		
		LocalDate startDate = LocalDate.of(2019, 9, 25);
		LocalDate endDate = LocalDate.of(2022, 10, 31);
		
		Period result = Period.between(startDate, endDate);
		
		System.out.println("Month: "+ result.getMonths());
		System.out.println("Year " + result.getYears());
		System.out.println("Days: "+ result.getDays());
		
		LocalTime startTime = LocalTime.parse("11:30");
		LocalTime endTime = LocalTime.parse("12:30");
		
		long totalSecs =Duration.between(startTime, endTime).getSeconds();
		System.out.println("Total Seconds: " +totalSecs);
	}
}
