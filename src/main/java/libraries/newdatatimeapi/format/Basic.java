package libraries.newdatatimeapi.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Basic {
	public static void main(String[] args) {
		String text = "1991年11月11日";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		LocalDate ld = LocalDate.parse(text, formatter);
		System.out.println(ld);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.getYear() + "年" + ldt.getMonthValue() + "月" + ldt.getDayOfMonth() + "日");
	}
}
