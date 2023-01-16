package com.emlakcepte.model;

import com.emlakcepte.model.enums.EstateType;

public class Category {
	private int id;
	private EstateType estateType;
	private String name;

	public Category(EstateType estateType, String name) {
		super();
		this.estateType = estateType;
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EstateType getEstateType() {
		return estateType;
	}

	public void setEstateType(EstateType estateType) {
		this.estateType = estateType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
