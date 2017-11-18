package com.up.clinicaveterinaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<ID, U> implements IGenericDAO<ID, U>{

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica_pu");
	private EntityManager em;
	private Class<U> entityClass;

	public GenericDAO(Class<U> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void beginTransaction() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}
	
	public boolean isTransactionActive() {
		if(em == null)
			return false;
		return em.getTransaction().isActive();
	}

	private void commit() {
		em.getTransaction().commit();
	}

	private void rollback() {
		em.getTransaction().rollback();
	}

	@Override
	public void rollbackAndCloseTransaction() {
		try {
			this.rollback();
		} finally {
			this.closeTransaction();
		}
	}

	private void closeTransaction() {
		this.em.close();
	}

	@Override
	public void commitAndCloseTransaction() {
		try {
			this.commit();
		} finally {
			this.closeTransaction();
		}
	}

	@Override
	public void flush() {
		em.flush();
	}

	@Override
	public void save(U entity) {
		em.persist(entity);
	}

	@Override
	public void delete(U entity) {
		em.refresh(entity);
		em.remove(entity);
	}

	@Override
	public U update(U entity) {
		return em.merge(entity);
	}

	@Override
	public U find(ID entityID) {
		return em.find(entityClass, entityID);
	}

	@Override
	public U findReferenceOnly(ID entityID) {
		try {
			return em.getReference(entityClass, entityID);
		} catch (EntityNotFoundException e) {
			return null;
		}
	}
	
	public static void fecharEntityManagerFactory(){
		emf.close();
	}
	
	protected EntityManager getEntityManager(){
		return em;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<U> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}
}