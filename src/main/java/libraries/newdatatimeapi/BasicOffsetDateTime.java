package libraries.newdatatimeapi;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class BasicOffsetDateTime {
	public static void main(String[] args) {
		OffsetDateTime now = OffsetDateTime.now();
		OffsetDateTime odt0 = OffsetDateTime.of(1991, 1, 1, 1, 1, 1, 1, ZoneOffset.ofHours(8));
		OffsetDateTime odt1 = OffsetDateTime.ofInstant(Instant.now(), ZoneOffset.ofHours(8));
		
		System.out.println(now);
		System.out.println(odt0);
		System.out.println(odt1);
	}
}
