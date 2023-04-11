package com.clock.talkingclock.services;

import com.clock.talkingclock.entity.Clock;

public interface ClockService {

	public Clock getCurrentTime();
	
	public Clock getTime(String userTime) throws Exception;
}
