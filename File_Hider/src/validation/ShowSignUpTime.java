package validation;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowSignUpTime {
	public static String currentTime() {
		LocalTime time = LocalTime.now();
		int hour = time.getHour();
		int minute = time.getMinute();
		return String.format("%02d:%02d", hour, minute);
	}

	public static String currentDate() {
		LocalDate date = LocalDate.now();
		int dd = date.getDayOfMonth();
		int mm = date.getMonthValue();
		int yyyy = date.getYear();
		return String.format("%02d-%02d-%d", dd, mm, yyyy);
	}
}