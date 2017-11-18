package com.up.clinicaveterinaria.facade;

import com.up.clinicaveterinaria.dao.TipoAnimalDAO;
import com.up.clinicaveterinaria.model.TipoAnimal;

public class TipoAnimalFacade extends GenericFacade<String, TipoAnimal, TipoAnimalDAO>{

	public TipoAnimalFacade() {
		super(new TipoAnimalDAO());
	}
}