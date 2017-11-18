package com.up.clinicaveterinaria.dao;

import java.util.List;

public interface IGenericDAO<ID, U> {
	
	public abstract void beginTransaction();

	public abstract void rollbackAndCloseTransaction();

	public abstract void commitAndCloseTransaction();

	public abstract void flush();

	public abstract void save(U entity);

	public abstract void delete(U entity);

	public abstract U update(U entity);

	public abstract U find(ID entityID);

	public abstract U findReferenceOnly(ID entityID);
	
	public boolean isTransactionActive();
	
	public List<U> findAll();
}