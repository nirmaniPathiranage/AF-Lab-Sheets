package com.mycompany.app.controller;

import com.mycompany.app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.app.service.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		// return new Greeting(counter.incrementAndGet(), String.format(template,
		// name));
		return greetingService.generateMessage(name);
	}

}
