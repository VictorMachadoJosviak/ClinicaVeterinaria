package com.up.clinicaveterinaria.facade;

import com.up.clinicaveterinaria.dao.AnimalDAO;
import com.up.clinicaveterinaria.model.Animal;

public class AnimalFacade extends GenericFacade<Integer, Animal, AnimalDAO>{

	public AnimalFacade() {
		super(new AnimalDAO());
	}
}