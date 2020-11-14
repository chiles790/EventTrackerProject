package com.skilldistillery.fitness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fitness.entities.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

}
