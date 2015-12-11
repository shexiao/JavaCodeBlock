package libraries.newdatatimeapi;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;

public class BasicLocalDate {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		LocalDate date0 = LocalDate.of(1991, 1, 20);
		LocalDate date1 = LocalDate.of(1992, Month.JANUARY, 20);
		LocalDate date2 = LocalDate.ofEpochDay(365);
		LocalDate date3 = LocalDate.ofYearDay(1991, 20);
		System.out.println(now);
		System.out.println(date0);
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
		
		LocalDate maxdate = LocalDate.MAX;
		LocalDate mindate = LocalDate.MIN;
		System.out.println(maxdate);
		System.out.println(mindate);
		
//		LocalDate from0 = LocalDate.from(); ?????
		
		LocalDate now1 = LocalDate.now(Clock.systemUTC());
		System.out.println(now1);
	}
}
