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

	private String comment;

	public Exercise() {
		super();
	}

	public Exercise(int id, String name, String description, Integer averageCaloriesPerHour, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.averageCaloriesPerHour = averageCaloriesPerHour;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "Exercise [id=" + id + ", name=" + name + ", description=" + description + ", averageCaloriesPerHour="
				+ averageCaloriesPerHour + ", comment=" + comment + "]";
	}

}
