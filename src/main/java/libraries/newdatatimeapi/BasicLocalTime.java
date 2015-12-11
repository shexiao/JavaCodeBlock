package libraries.newdatatimeapi;

import java.time.LocalTime;

public class BasicLocalTime {
	public static void main(String[] args) {
		LocalTime now = LocalTime.now();
		LocalTime time0 = LocalTime.of(1, 10);
		LocalTime time1 = LocalTime.of(1, 10, 10);
		LocalTime time2 = LocalTime.of(1, 10, 10, 1000);
		LocalTime time3 = LocalTime.ofNanoOfDay(12313123321300l);
		LocalTime time4 = LocalTime.ofSecondOfDay(10000L);
		
		System.out.println(now);
		System.out.println(time0);
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
		System.out.println(time4);
	}
}
