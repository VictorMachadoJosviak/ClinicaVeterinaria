package com.up.clinicaveterinaria.dao;

import com.up.clinicaveterinaria.model.VacinaAnimal;
import com.up.clinicaveterinaria.model.VacinaAnimalID;

public class VacinaAnimalDAO extends GenericDAO<VacinaAnimalID, VacinaAnimal>{

	public VacinaAnimalDAO() {
		super(VacinaAnimal.class);
	}
}