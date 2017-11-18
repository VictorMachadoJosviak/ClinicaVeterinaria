package com.up.clinicaveterinaria.dao;

import com.up.clinicaveterinaria.model.Especie;

public class EspecieDAO extends GenericDAO<Long, Especie>{
	public EspecieDAO() {
		super(Especie.class);
	}
}