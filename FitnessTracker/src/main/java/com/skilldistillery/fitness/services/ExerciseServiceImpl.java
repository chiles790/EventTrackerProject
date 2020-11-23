package com.skilldistillery.fitness.services;

import java.util.List;
import java.util.Optional;

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
		return repo.findAll();
	}

	@Override
	public Exercise findById(Integer exId) {
		Optional<Exercise> exOpt = repo.findById(exId);
		Exercise ex = null;
		if (exOpt.isPresent()) {
			ex = exOpt.get();
		}
		return ex;
	}

	@Override
	public Exercise create(Exercise exercise) {
		exercise = repo.saveAndFlush(exercise);
		return exercise;

	}

	@Override
	public Exercise update(Integer exId, Exercise exercise) {
		Optional<Exercise> exOpt = repo.findById(exId);
		Exercise manageEx = null;
		if (exOpt.isPresent()) {
			manageEx = exOpt.get();
			if (exercise.getName() != null) {
				manageEx.setName(exercise.getName());
			}
			if (exercise.getDescription() != null) {
				manageEx.setDescription(exercise.getDescription());
			}
			if (exercise.getAverageCaloriesPerHour() != null) {
				manageEx.setAverageCaloriesPerHour(exercise.getAverageCaloriesPerHour());
			}
			if (exercise.getComments() != null) {
				manageEx.setComments(exercise.getComments());
			}
			if(exercise.getTypeOfExercise() != null) {
				manageEx.setTypeOfExercise(exercise.getTypeOfExercise());
			}
			repo.flush();
		}
		return manageEx;
	}

	@Override
	public boolean delete(Integer exId) {
		boolean deleted = false;
		Optional<Exercise> exOpt = repo.findById(exId);
		if(exOpt.isPresent()) {
			repo.delete(exOpt.get());
			deleted = true;
		}
		return false;
	}

//	@Override
//	public List<Exercise> getByTypeOfExercise(String keyword) {
//		keyword = "%" + keyword + "%";
//		return repo.findByTypeOfExercise(keyword);
//	}
	
}
