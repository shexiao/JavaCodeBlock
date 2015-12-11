package libraries.newdatatimeapi;

import java.time.Month;
import java.time.MonthDay;

public class BasicMonthDay {
	public static void main(String[] args) {
		MonthDay now = MonthDay.now();
		MonthDay md0 = MonthDay.of(Month.APRIL, 1);
		
		System.out.println(now);
		System.out.println(md0);
	}
}
