import java.time.LocalDateTime;

public class TalkingClock {

	public static void main(String[] args) {

		int hrs;
		int mins;

		StringBuffer userTime = new StringBuffer();

		TimeToWordConvertor clock = new TimeToWordConvertor();

		try {

			for (String input : args)
				userTime.append(input);

			if (userTime.toString().trim().length() == 0) {
				LocalDateTime currentTime = LocalDateTime.now();
				hrs = currentTime.getHour();
				mins = currentTime.getMinute();

			} else {
				clock.validate(userTime.toString().trim().trim());
				String[] timing = userTime.toString().trim().split(":");
				hrs = Integer.parseInt(timing[0]);
				mins = Integer.parseInt(timing[1]);
			}
			
			System.out.println(clock.getClockTimeInWords(hrs, mins));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
