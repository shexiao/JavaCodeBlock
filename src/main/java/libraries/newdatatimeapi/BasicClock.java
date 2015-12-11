package libraries.newdatatimeapi;

import java.time.Clock;
import java.time.Duration;
import java.time.ZoneOffset;


public class BasicClock {
	public static void main(String[] args) {
		Clock defaultClock = Clock.systemDefaultZone();
		Clock utcClock = Clock.systemUTC();
		Clock clock0 = Clock.offset(utcClock, Duration.ZERO.plusHours(8));
		Clock clock1 = Clock.tickMinutes(ZoneOffset.systemDefault());
		
		System.out.println(defaultClock);
		System.out.println(utcClock);
		System.out.println(clock0);
		System.out.println(clock1);
	}
}
