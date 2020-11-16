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
	public Exercise findById(Integer id) {
		Optional<Exercise> exOpt = repo.findById(id);
		Exercise ex = null;
		if (exOpt.isPresent()) {
			ex = exOpt.get();
		}
		return ex;
	}

	@Override
	public Exercise create(Exercise ex) {
		ex = repo.saveAndFlush(ex);
		return ex;

	}

	@Override
	public Exercise update(Integer id, Exercise ex) {
		Optional<Exercise> exOpt = repo.findById(id);
		Exercise manageEx = null;
		if (exOpt.isPresent()) {
			manageEx = exOpt.get();
			if (ex.getName() != null) {
				manageEx.setName(ex.getName());
			}
			if (ex.getDescription() != null) {
				manageEx.setDescription(ex.getDescription());
			}
			if (ex.getAverageCaloriesPerHour() != null) {
				manageEx.setAverageCaloriesPerHour(ex.getAverageCaloriesPerHour());
			}
			if (ex.getComments() != null) {
				manageEx.setComments(ex.getComments());
			}
			if(ex.getTypeOfExercise() != null) {
				manageEx.setTypeOfExercise(ex.getTypeOfExercise());
			}
			repo.flush();
		}
		return manageEx;
	}

	@Override
	public boolean delete(Integer id) {
		boolean deleted = false;
		Optional<Exercise> exOpt = repo.findById(id);
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
