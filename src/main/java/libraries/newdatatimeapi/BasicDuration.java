package libraries.newdatatimeapi;

import java.time.Duration;

public class BasicDuration {
	public static void main(String[] args) {
		Duration duration = Duration.ZERO;
		Duration duration1 = Duration.ofDays(1);
		
		System.out.println(duration);
		System.out.println(duration1);
	}
}
