package com.duongnv.spring.service.system;

import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.jboss.aerogear.security.otp.api.Clock;

public class MyClock extends Clock {

	private long startTime;

	public MyClock() {
		super();
		startTime = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
	}

	public MyClock(int interval) {
		super(interval);
		startTime = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
	}

	public MyClock(int interval, long startTimeInSeconds) {
		super(interval);
		this.startTime = startTimeInSeconds;
	}

	public long getCurrentInterval() {
		long currentTimeSeconds = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis() - startTime;
		 currentTimeSeconds = currentTimeSeconds / 1000;
		return currentTimeSeconds ;
	}

	public long getStartTime() {
		return startTime;
	}

}
