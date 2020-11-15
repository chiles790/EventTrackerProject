package com.skilldistillery.fitness.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.fitness.entities.Exercise;
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

	@GetMapping("exercise")
	public List<Exercise> index() {
		return svc.getAllExercise();
	}

	@GetMapping("exercise/{id}")
	public Exercise show(@PathVariable Integer id, HttpServletResponse response) {
		Exercise ex = svc.findById(id);
		if (ex == null) {
			response.setStatus(404);
		}
		return ex;
	}

	@PostMapping("exercise")
	public Exercise create(@RequestBody Exercise ex, HttpServletResponse response) {
		ex = svc.create(ex);
		return ex;
	}
	
	@PutMapping("exercise/{id}")
	public Exercise Update(@PathVariable Integer id, @RequestBody Exercise ex, HttpServletResponse response) {
		ex = svc.update(id, ex);
		
		return ex;
	}
	
	@DeleteMapping("exercise/{id}")
	public void delete(@PathVariable Integer id, HttpServletResponse response) {
		boolean deleted = svc.delete(id);
		if(deleted) {
			response.setStatus(204);
		}
		
	}
}
