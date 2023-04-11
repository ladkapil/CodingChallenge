
public class TimeToWordConvertor {

	public void validate(String userTime) throws IllegalArgumentException {

		// regex patterns to check valid 24 hours format
		String regexTillTwentyHours = "^[0-1]?[0-9]:[0-5][0-9]$";   // Allows [0:00 to 09:59] and [00:00 to 10:00 to 19:59]
		String regexAfterTwentyhours = "^2[0-3]:[0-5][0-9]$";       // Allows [20:00 to 23:59]
		String regexForTwentyFourhour = "^2[4]:[0][0]$";            // Allows [24:00]

		// method to verify appropriate time format
		if (!(userTime.matches(regexForTwentyFourhour)  
				|| userTime.matches(regexTillTwentyHours)
				|| userTime.matches(regexAfterTwentyhours))) {
			throw new IllegalArgumentException("Please enter valid time in HH:MM format.");
		}
	}
	
	
	// convert the given time into words
	public String getClockTimeInWords(int hour, int min) {

		final String BLANK = " ";

		String time[] = { "o'clock", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Eleven", "Twelve", "Thirteen", "Fourteen", "Quarter", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
				"Twenty" };

		String minutes;

		String appender = min > 30 ? "to" : "past";

		if (hour == 24)
			hour = 0;

		switch ((min == 30) ? 0
				: (min >= 40 && min < 60) ? 1 : (min > 30 && min < 40) ? 2 : (min > 20 && min < 30) ? 3 : 4) {

		case 0:
			minutes = "Half";
			break;
		case 1:
			min = 60 - min;
			hour = hour + 1;
			minutes = time[min];
			break;
		case 2:
			min = 60 - min;
			hour = hour + 1;
			minutes = time[20] + BLANK + time[min-20].toLowerCase();
			break;
		case 3:
			minutes = time[20] + BLANK + time[min-20].toLowerCase();
			break;
		default:
			minutes = time[min];
			break;
		}

		hour = (hour > 12) ? (hour - 12) : (hour == 0) ? 12 : hour;

		return (min == 0) ? (time[hour] + BLANK + time[0])
				: (minutes + BLANK + appender + BLANK + time[hour].toLowerCase());
	}

}
