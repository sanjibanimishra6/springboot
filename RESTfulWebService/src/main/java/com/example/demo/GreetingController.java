package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//The controller ensure that the class ill control how the object will be used
//It is done using two parts:
//1. get mapping
//2.Request parameters

@RestController
public class GreetingController {
//	%s is the place holder of the runtime value
	// for example if user inputs abcd then results will be Hello abcd
	private static final String template = "Yellow, %s";
// Atomic long is data type that will handle huge data.
	private final AtomicLong atomicLong = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Mishra") String name) {
		return new Greeting(atomicLong.incrementAndGet(), String.format(template,name));
	}
}
