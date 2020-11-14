package com.skilldistillery.fitness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fitness.entities.Exercise;
import com.skilldistillery.fitness.repositories.ExerciseRepository;
@Service
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseRepository repo;
	@Override
	public List<Exercise> getAllExercise() {
		// TODO Auto-generated method stub
		return null;
	}

}
