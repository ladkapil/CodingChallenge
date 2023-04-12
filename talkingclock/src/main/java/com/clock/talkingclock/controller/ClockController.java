package com.clock.talkingclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clock.talkingclock.entity.Clock;
import com.clock.talkingclock.services.ClockService;

@RestController
@RequestMapping("/")
public class ClockController {
	
	@Autowired
	private ClockService clockService;
	
	@GetMapping("/getTime")
	public Clock getTime(){
		return this.clockService.getCurrentTime();
	}
	
	@GetMapping("/getTime/{userTime}")
	public Clock getTime(@PathVariable String userTime) throws Exception{
		return this.clockService.getTime(userTime);
	}
	
}
