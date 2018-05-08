package com.journaldev.java8.time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class JavaClockExample {

	public static void main(String[] args) throws InterruptedException {
		
		//1. Simple example with default system time zone
		Clock clock = Clock.systemDefaultZone();
		System.out.println(clock.getZone());

		//2. Clock instant example
		Instant instant = clock.instant();
		System.out.println(instant);
		
		//3. UTC Time zone
		clock = Clock.systemUTC();
		System.out.println(clock.getZone());

		//4. using specific time zone
		clock = Clock.system(ZoneId.of("Europe/Paris"));
		System.out.println(clock.instant());
		
		//5. Get current milliseconds
		System.out.println(clock.millis());
		System.out.println(System.currentTimeMillis());
		
		//6. Offset to future or past time
		Clock pastClock = Clock.offset(clock, Duration.ofMillis(-10000));
		System.out.println(clock.millis() - pastClock.millis());

		Clock futureClock = Clock.offset(clock, Duration.ofDays(1));
		System.out.println(futureClock.millis() - clock.millis());
		
		//7. tick example
		Clock nearestHourClock = Clock.tick(clock, Duration.ofHours(1));
		System.out.println(clock.instant());
		System.out.println(nearestHourClock.instant());
		
		Clock nearestSecondClock = Clock.tickSeconds(ZoneId.systemDefault());
		System.out.println(nearestSecondClock);
		System.out.println(nearestSecondClock.instant());
		
		//8. Fixed Clock
		Clock fixedClock = Clock.fixed(instant, ZoneId.systemDefault());
		System.out.println(fixedClock);
		System.out.println(fixedClock.instant());
		Thread.sleep(1000);
		System.out.println(fixedClock.instant());

	}

}
