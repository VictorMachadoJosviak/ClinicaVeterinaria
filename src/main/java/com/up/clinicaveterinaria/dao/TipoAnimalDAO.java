package com.up.clinicaveterinaria.dao;

import com.up.clinicaveterinaria.model.TipoAnimal;

public class TipoAnimalDAO extends GenericDAO<String, TipoAnimal>{
	public TipoAnimalDAO() {
		super(TipoAnimal.class);
	}
}