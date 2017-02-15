package com.jones.maxsatisfaction;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jones.maxsatisfaction.util.CalculateMaxSatisfaction;
import com.jones.maxsatisfaction.util.ReadData;

@SpringBootApplication
public class MaxSatisfactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxSatisfactionApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CalculateMaxSatisfaction calculateMaxSatisfaction) {

		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				int timeLimit=ReadData.captureTime();
				int maxSatisfaction=calculateMaxSatisfaction.findMaxSatisfaction(timeLimit);
				System.out.println("The max satisfaction that can be obtained against the "
						+ "time is : "+maxSatisfaction);

			}

		};

	}
}