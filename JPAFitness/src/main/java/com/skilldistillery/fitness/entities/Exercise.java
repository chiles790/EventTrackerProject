package com.skilldistillery.fitness.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;

	@Column(name = "average_calories_per_hour")
	private Integer averageCaloriesPerHour;

	private String comments;

	@Column(name = "type_of_exercise")
	private String typeOfExercise;

	public Exercise() {
		super();
	}

	public Exercise(int id, String name, String description, Integer averageCaloriesPerHour, String comments,
			String typeOfExercise) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.averageCaloriesPerHour = averageCaloriesPerHour;
		this.comments = comments;
		this.typeOfExercise = typeOfExercise;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAverageCaloriesPerHour() {
		return averageCaloriesPerHour;
	}

	public void setAverageCaloriesPerHour(Integer averageCaloriesPerHour) {
		this.averageCaloriesPerHour = averageCaloriesPerHour;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTypeOfExercise() {
		return typeOfExercise;
	}

	public void setTypeOfExercise(String typeOfExercise) {
		this.typeOfExercise = typeOfExercise;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Exercise [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", averageCaloriesPerHour=");
		builder.append(averageCaloriesPerHour);
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", typeOfExercise=");
		builder.append(typeOfExercise);
		builder.append("]");
		return builder.toString();
	}
	

}
