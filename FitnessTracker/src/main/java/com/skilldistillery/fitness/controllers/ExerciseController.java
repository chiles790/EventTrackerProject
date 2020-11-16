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

	@GetMapping("exercise/{id}")
	public Exercise show(@PathVariable Integer id, HttpServletResponse response) {
		Exercise ex = svc.findById(id);
		if (ex == null) {
			response.setStatus(404);
		}
		return ex;
	}

	@PostMapping("exercise")
	public Exercise create(@RequestBody Exercise ex, HttpServletResponse response, HttpServletRequest request) {
		try{
			ex = svc.create(ex);
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/").append(ex.getId());
			String urlstr = url.toString();
			response.setHeader("Location", urlstr);
		}catch (Exception e) {
			response.setStatus(400);
			ex = null;
		}
		return ex;
	}
	
	@PutMapping("exercise/{id}")
	public Exercise Update(@PathVariable Integer id, @RequestBody Exercise ex, HttpServletResponse response) {
		try {
			ex = svc.update(id, ex);
			if(ex == null) {
				response.setStatus(404);
			}
		} catch (Exception e) {
			response.setStatus(400);
			ex = null;
		}
		
		return ex;
	}
	
	@DeleteMapping("exercise/{id}")
	public void delete(@PathVariable Integer id, HttpServletResponse response) {
		try {
			boolean deleted = svc.delete(id);
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
