package com.up.clinicaveterinaria.facade;

import com.up.clinicaveterinaria.dao.VacinaDAO;
import com.up.clinicaveterinaria.model.Vacina;

public class VacinaFacade extends GenericFacade<Integer, Vacina, VacinaDAO>{

	public VacinaFacade() {
		super(new VacinaDAO());
	}
}