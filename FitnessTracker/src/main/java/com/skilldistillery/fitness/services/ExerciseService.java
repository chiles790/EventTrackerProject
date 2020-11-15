package com.skilldistillery.fitness.services;

import java.util.List;

import com.skilldistillery.fitness.entities.Exercise;

public interface ExerciseService {
List<Exercise> getAllExercise();

Exercise findById(Integer id);

Exercise create(Exercise ex);

Exercise update(Integer id, Exercise ex);

boolean delete(Integer id);
}
