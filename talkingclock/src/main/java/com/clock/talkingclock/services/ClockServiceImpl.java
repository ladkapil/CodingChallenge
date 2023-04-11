package com.clock.talkingclock.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.clock.talkingclock.entity.Clock;

@Service
public class ClockServiceImpl implements ClockService {

	@Override
	public Clock getCurrentTime() {
		LocalDateTime currentTime = LocalDateTime.now();
		int hrs = currentTime.getHour();
		int mins = currentTime.getMinute();

		Clock clock = new Clock();
		clock.setValue(getClockTimeInWords(hrs, mins));
		
		return clock;
	}

	@Override
	public Clock getTime(String userTime) throws Exception {

		Clock clock = new Clock();

		validate(userTime);
		String[] timing = userTime.toString().trim().split(":");
		int hrs = Integer.parseInt(timing[0]);
		int mins = Integer.parseInt(timing[1]);

		clock.setValue(getClockTimeInWords(hrs, mins));
		return clock;
	}

	public void validate(String userTime) throws Exception {

		// regex patterns to check valid 24 hours format
		String regexTillTwentyHours = "^[0-1]?[0-9]:[0-5][0-9]$";   // Allows [0:00 to 09:59] and [00:00 to 10:00 to 19:59]
		String regexAfterTwentyhours = "^2[0-3]:[0-5][0-9]$";       // Allows [20:00 to 23:59]
		String regexForTwentyFourhour = "^2[4]:[0][0]$";            // Allows [24:00]

		// method to verify appropriate time format
		if (!(userTime.matches(regexForTwentyFourhour)  
				|| userTime.matches(regexTillTwentyHours)
				|| userTime.matches(regexAfterTwentyhours))) {
			throw new IllegalArgumentException();
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

		switch ((min == 30) ? 0	:
	(min >= 40 && min < 60) ? 1 : 
	 (min > 30 && min < 40) ? 2 : 
	 (min > 20 && min < 30) ? 3 : 4) {

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
			minutes = time[20] + BLANK + time[min - 20].toLowerCase();
			break;
		case 3:
			minutes = time[20] + BLANK + time[min - 20].toLowerCase();
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
