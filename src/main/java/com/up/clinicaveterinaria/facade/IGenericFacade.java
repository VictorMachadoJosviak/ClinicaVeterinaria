package com.up.clinicaveterinaria.facade;

import java.util.List;

public interface IGenericFacade<ID, U> {

	public void save(U entity) throws Exception;

	public void delete(ID idEntity) throws Exception;

	public void update(U entity) throws Exception;

	public U find(ID entityID) throws Exception;

	public U findReferenceOnly(ID entityID) throws Exception;
	
	public List<U> listAll();
}