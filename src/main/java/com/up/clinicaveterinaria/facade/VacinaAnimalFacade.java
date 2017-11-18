package com.up.clinicaveterinaria.facade;

import com.up.clinicaveterinaria.dao.VacinaAnimalDAO;
import com.up.clinicaveterinaria.model.VacinaAnimal;
import com.up.clinicaveterinaria.model.VacinaAnimalID;

public class VacinaAnimalFacade extends GenericFacade<VacinaAnimalID, VacinaAnimal, VacinaAnimalDAO>{

	public VacinaAnimalFacade() {
		super(new VacinaAnimalDAO());
	}
}
