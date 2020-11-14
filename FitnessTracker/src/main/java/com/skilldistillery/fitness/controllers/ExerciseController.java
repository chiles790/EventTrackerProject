package com.skilldistillery.fitness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.fitness.services.ExerciseService;

@RequestMapping("api")
@RestController
public class ExerciseController {

	@Autowired
	private ExerciseService svc;
	
	@GetMapping("ping")
	public String ping() {
		return "pong!";
	}
}
