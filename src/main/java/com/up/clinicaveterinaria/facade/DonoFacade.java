package com.up.clinicaveterinaria.facade;

import com.up.clinicaveterinaria.dao.DonoDAO;
import com.up.clinicaveterinaria.model.Dono;

public class DonoFacade extends GenericFacade<Integer, Dono, DonoDAO>{

	public DonoFacade() {
		super(new DonoDAO());
	}
}
