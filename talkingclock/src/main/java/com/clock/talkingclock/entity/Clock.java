package com.clock.talkingclock.entity;

public class Clock {
	
	private String value;

	Clock(String result){
		this.value = result;
	}
	
	public Clock() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "Clock [value=" + value + "]";
	}
}
