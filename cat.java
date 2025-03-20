package com.csc340.sp25_crud_api_demo.animal;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cats")  // Changed table name from 'dogs' to 'cats'
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;  // Changed from 'dogId' to 'catId'

	@Column(nullable = false)
	private String name;

	private String description;

	@Column(nullable = false)
	private String breed;

	@Column(nullable = false)
	private double age;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date activeDate;

	// Constructor for all fields
	public Cat(int catId, String name, String description, String breed, double age, Date activeDate) {
		this.catId = catId;
		this.name = name;
		this.description = description;
		this.breed = breed;
		this.age = age;
		this.activeDate = activeDate;
	}

	// Constructor without catId for creating new Cat
	public Cat(String name, String description, String breed, double age, Date activeDate) {
		this.name = name;
		this.description = description;
		this.breed = breed;
		this.age = age;
		this.activeDate = activeDate;
	}

	// No-argument constructor (required by JPA)
	public Cat() {
	}

	// Getters and Setters

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
}
