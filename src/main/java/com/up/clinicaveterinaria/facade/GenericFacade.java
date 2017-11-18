package com.up.clinicaveterinaria.facade;

import java.util.List;

import com.up.clinicaveterinaria.dao.IGenericDAO;

public class GenericFacade <ID, U, DAO extends IGenericDAO<ID, U>> implements IGenericFacade<ID, U>{

	protected DAO dao;
	
	public GenericFacade(DAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void save(U obj) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(obj);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public void update(U animal) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(animal);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public U find(ID id) throws Exception {
		try {
			dao.beginTransaction();
			U obj = dao.find(id);
			dao.commitAndCloseTransaction();
			return obj;
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public void delete(ID id) throws Exception {
		try {
			dao.beginTransaction();
			U obj = dao.findReferenceOnly(id);
			dao.delete(obj);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public U findReferenceOnly(ID entityID) throws Exception {
		try {
			dao.beginTransaction();
			U obj = dao.findReferenceOnly(entityID);
			dao.commitAndCloseTransaction();
			return obj;
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	@Override
	public List<U> listAll() {
		try {
			dao.beginTransaction();
			List<U> lista = dao.findAll();
			dao.commitAndCloseTransaction();
			return lista;
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}