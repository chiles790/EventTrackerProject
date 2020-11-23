package com.skilldistillery.fitness.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

	@GetMapping("exercise/{exId}")
	public Exercise show(@PathVariable Integer exId, HttpServletResponse response) {
		Exercise ex = svc.findById(exId);
		if (ex == null) {
			response.setStatus(404);
		}
		return ex;
	}

	@PostMapping("exercise")
	public Exercise create(@RequestBody Exercise exercise, HttpServletResponse response, HttpServletRequest request) {
		try{
			exercise = svc.create(exercise);
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/").append(exercise.getId());
			String urlstr = url.toString();
			response.setHeader("Location", urlstr);
		}catch (Exception e) {
			response.setStatus(400);
			exercise = null;
		}
		return exercise;
	}
	
	@PutMapping("exercise/{exId}")
	public Exercise Update(@PathVariable Integer exId, @RequestBody Exercise exercise, HttpServletResponse response) {
		try {
			exercise = svc.update(exId, exercise);
			if(exercise == null) {
				response.setStatus(404);
			}
		} catch (Exception e) {
			response.setStatus(400);
			exercise = null;
		}
		
		return exercise;
	}
	
	@DeleteMapping("exercise/{exId}")
	public void delete(@PathVariable Integer exId, HttpServletResponse response) {
		try {
			boolean deleted = svc.delete(exId);
			if(deleted) {
				response.setStatus(204);
			}else {
				response.setStatus(404);
			}
		} catch (Exception e) {
			response.setStatus(400);
		}
	}
	
//	@GetMapping("exercise/search/{keyword}")
//	public List<Exercise> getExerciseByTypeOfExercise(String keyword){
//	
//		return svc.getByTypeOfExercise(keyword);
//	}
}
