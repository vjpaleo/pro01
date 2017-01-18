package com.pro01.model;

public class FruitGroup {
	
	private int id;
	private String name;
	private String description;

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
	
	@Override
	public String toString() {
		return "Food group id: " + this.id + ", name: " + this.name + ", description: " + this.description + ".";
	}

}
