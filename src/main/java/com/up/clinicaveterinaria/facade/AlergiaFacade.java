package com.up.clinicaveterinaria.facade;

import com.up.clinicaveterinaria.dao.AlergiaDAO;
import com.up.clinicaveterinaria.model.Alergia;

public class AlergiaFacade extends GenericFacade<Integer, Alergia, AlergiaDAO>{

	public AlergiaFacade(AlergiaDAO dao) {
		super(dao);
	}
}