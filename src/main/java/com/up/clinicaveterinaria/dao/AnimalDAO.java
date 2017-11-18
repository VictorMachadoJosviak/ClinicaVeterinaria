package com.up.clinicaveterinaria.dao;

import com.up.clinicaveterinaria.model.Animal;

public class AnimalDAO extends GenericDAO<Integer, Animal>{
	
	public AnimalDAO() {
		super(Animal.class);
	}
}