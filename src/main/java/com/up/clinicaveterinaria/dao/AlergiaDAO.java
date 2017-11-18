package com.up.clinicaveterinaria.dao;

import com.up.clinicaveterinaria.model.Alergia;

public class AlergiaDAO extends GenericDAO<Integer, Alergia>{
	public AlergiaDAO() {
		super(Alergia.class);
	}
}