package com.up.clinicaveterinaria.facade;

import com.up.clinicaveterinaria.dao.EspecieDAO;
import com.up.clinicaveterinaria.model.Especie;

public class EspecieFacade extends GenericFacade<Long, Especie, EspecieDAO>{

	public EspecieFacade() {
		super(new EspecieDAO());
	}
}