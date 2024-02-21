package com.reform.testTaskReform;

import com.reform.testTaskReform.repository.AddressRepository;
import com.reform.testTaskReform.repository.RouteRepository;
import com.reform.testTaskReform.repository.UserRepository;
import com.reform.testTaskReform.rest.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class TestTaskReformApplication {

	public static void main(String[] args) {
		var cont = SpringApplication.run(TestTaskReformApplication.class, args);
		System.out.println(cont.getBean(RouteRepository.class).findById((long) 2));
	}

}
