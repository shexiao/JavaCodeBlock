package libraries.newdatatimeapi;

import java.time.Instant;

public class BasicInstant {
	public static void main(String[] args) {
		Instant instant = Instant.EPOCH;
		Instant instant1 = Instant.ofEpochMilli(1312312123123L);
		
		System.out.println(instant);
		System.out.println(instant1);
	}
}
