package com.skilldistillery.fitness.services;

import java.util.List;

import com.skilldistillery.fitness.entities.Exercise;

public interface ExerciseService {
List<Exercise> getAllExercise();

Exercise findById(Integer exId);

Exercise create(Exercise exercise);

Exercise update(Integer exId, Exercise exercise);

boolean delete(Integer exId);

//List<Exercise> getByTypeOfExercise(String keyword);
}
