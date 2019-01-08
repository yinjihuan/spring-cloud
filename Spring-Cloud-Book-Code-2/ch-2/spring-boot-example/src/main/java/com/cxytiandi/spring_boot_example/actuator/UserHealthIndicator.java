package com.cxytiandi.spring_boot_example.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class UserHealthIndicator extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		builder.up().withDetail("status", true);
		//builder.down().withDetail("status", false);
	}

}
