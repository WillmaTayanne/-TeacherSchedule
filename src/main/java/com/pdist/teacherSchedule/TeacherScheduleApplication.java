package com.pdist.teacherSchedule;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class TeacherScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherScheduleApplication.class, args);
	}

}
