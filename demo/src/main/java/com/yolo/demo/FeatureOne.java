package com.yolo.demo;

import com.yolo.annotations.Bean;
import com.yolo.annotations.Configuration;
import com.yolo.annotations.Qualifier;


@Configuration
public class FeatureOne {

	@Bean
	public ActivityOne activityOne(ServiceRegistration serviceRegistration, @Qualifier("oracle") Database database) {
		return new ActivityOne(serviceRegistration, database);
	}

}
