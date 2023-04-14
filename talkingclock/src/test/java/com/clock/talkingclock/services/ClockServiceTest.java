package com.clock.talkingclock.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.clock.talkingclock.entity.Clock;

public class ClockServiceTest {
	
	private ClockService clockService;
	
	@Before
	public void setup() {
		clockService = new ClockServiceImpl();
	}
	
	@Test
	public void getCurrentTime_returns_current_time_in_word_format() {
	
		assertNotNull(clockService.getCurrentTime());
	}

	@Test
	public void testGetTime_results_with_exact_hour_clock_format() throws Exception {
		String userTime = "12:00";
		String expectedResult = "Twelve o'clock";
		
		Clock clock = clockService.getTime(userTime);
		assertNotNull(clock.getValue());
		assertTrue(clock.getValue().equals(expectedResult));
	}
	
	@Test
	public void testGetTime_results_with_midnight_hour_clock_format() throws Exception {
		String userTime = "00:00";
		String expectedResult = "Twelve o'clock";
		
		Clock clock = clockService.getTime(userTime);
		assertNotNull(clock.getValue());
		assertTrue(clock.getValue().equals(expectedResult));
	}
	
	@Test
	public void testGetTime_results_with_24_hour_clock_format() throws Exception {
		String userTime = "24:00";
		String expectedResult = "Twelve o'clock";
		
		Clock clock = clockService.getTime(userTime);
		assertNotNull(clock.getValue());
		assertTrue(clock.getValue().equals(expectedResult));
	}
	
	@Test
	public void testGetTime_results_with_quarter_past_format() throws Exception {
		String userTime = "12:15";
		String expectedResult = "Quarter past twelve";
		
		Clock clock = clockService.getTime(userTime);
		assertNotNull(clock.getValue());
		assertTrue(clock.getValue().equals(expectedResult));
	}
	
	@Test
	public void testGetTime_results_with_half_past_format() throws Exception {
		String userTime = "12:30";
		String expectedResult = "Half past twelve";
		
		Clock clock = clockService.getTime(userTime);
		assertNotNull(clock.getValue());
		assertTrue(clock.getValue().equals(expectedResult));
	}
	
	@Test
	public void testGetTime_results_with_quarter_to_format() throws Exception {
		String userTime = "12:45";
		String expectedResult = "Quarter to one";
		
		Clock clock = clockService.getTime(userTime);
		assertNotNull(clock.getValue());
		assertTrue(clock.getValue().equals(expectedResult));
	}
	
	
	@Test
	public void testGetTime_results_with_valid_quarter_to_format() throws Exception {
		String userTime = "01:45";
		String expectedResult = "Quarter to two";
		
		Clock clock = clockService.getTime(userTime);
		assertNotNull(clock.getValue());
		assertTrue(clock.getValue().equals(expectedResult));
	}
	
	@Test
	public void testGetTime_results_with_invalid_quarter_format() throws Exception {
		String userTime = "1:45";
		String expectedResult = "Fourty five past one";
		
		Clock clock = clockService.getTime(userTime);
		assertNotNull(clock.getValue());
		assertFalse(clock.getValue().equals(expectedResult));
		assertTrue(clock.getValue().equals("Quarter to two"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetTime_results_exception_when_invalid_hours() throws Exception {
		String userTime = "25:15";
		
		Clock clock = clockService.getTime(userTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetTime_results_exception_when_invalid_time() throws Exception {
		String userTime = "24:15";
		
		Clock clock = clockService.getTime(userTime);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetTime_results_exception_when_invalid_minutes() throws Exception {
		String userTime = "22:60";
		
		Clock clock = clockService.getTime(userTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetTime_results_exception_when_space_in_minutes() throws Exception {
		String userTime = "22:4 0";
		
		Clock clock = clockService.getTime(userTime);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetTime_results_exception_when_invalide_hours() throws Exception {
		String userTime = "212:40";
		
		Clock clock = clockService.getTime(userTime);
	}
}
