package com.adminpanel.attendance_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.controller", "com.entity","com.service","com.repository"})
@EnableJpaRepositories("com.repository")  // Scan the repository package
@EntityScan("com.entity")  // Scan the entity package
public class AttendanceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceSystemApplication.class, args);
	}

}
