package com.mycompany.app.service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.mycompany.app.model.Greeting;
import com.mycompany.app.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	public Greeting generateMessage(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
