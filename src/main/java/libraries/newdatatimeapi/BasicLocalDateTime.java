package libraries.newdatatimeapi;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;

public class BasicLocalDateTime {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime datetime0 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		LocalDateTime datetime1 = LocalDateTime.of(1991, 1, 1, 1, 1);
		LocalDateTime datetime2 = LocalDateTime.of(1991, Month.JANUARY, 1, 1, 1);
		LocalDateTime datetime3 = LocalDateTime.of(1991, 1, 1, 1, 1, 1);
		LocalDateTime datetime4 = LocalDateTime.of(1991, Month.JANUARY, 1, 1, 1, 1);
		LocalDateTime datetime5 = LocalDateTime.of(1991, 1, 1, 1, 1, 1, 1);
		LocalDateTime datetime6 = LocalDateTime.of(1991, Month.JANUARY, 1, 1, 1, 1, 1);
		LocalDateTime datetime7 = LocalDateTime.ofEpochSecond(1238123813L, 12312312, ZoneOffset.ofHours(8));
		LocalDateTime datetime8 = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.systemDefault());
		
		System.out.println(now);
		System.out.println(datetime0);
		System.out.println(datetime1);
		System.out.println(datetime2);
		System.out.println(datetime3);
		System.out.println(datetime4);
		System.out.println(datetime5);
		System.out.println(datetime6);
		System.out.println(datetime7);
		System.out.println(datetime8);
	}
}
