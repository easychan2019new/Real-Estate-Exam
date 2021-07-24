package com.alexande.realestateexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableScheduling
@SpringBootApplication
public class RealEstateExamApplication extends SpringBootServletInitializer {

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
	}

	public static void main(String[] args) {
		SpringApplication.run(RealEstateExamApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RealEstateExamApplication.class);
	}
}
