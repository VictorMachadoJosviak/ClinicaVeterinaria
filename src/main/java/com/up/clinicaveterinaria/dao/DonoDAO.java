package com.up.clinicaveterinaria.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.up.clinicaveterinaria.model.Dono;

public class DonoDAO extends GenericDAO<Integer, Dono> {
	public DonoDAO() {
		super(Dono.class);
	}

	public Dono findByCPF(Long cpf) {
		Query query = super.getEntityManager().createNamedQuery("Dono.findBycpf");
		query.setParameter("cpf", cpf);
		try {
			Dono retorno = (Dono) query.getSingleResult();
			return retorno;
		}catch (NoResultException ex) {
			return null;
		}
	}

	public List<Dono> listar() {
		String sql = "select d from Dono d";
		Query query = super.getEntityManager().createQuery(sql);

		@SuppressWarnings("unchecked")
		List<Dono> retorno = query.getResultList();
		return retorno;
	}

	public List<Dono> listarPessoasQuePossuemTipoAnimal(String acronimo) {
		String sql = "select d from Dono d" + " inner join d.animais a" + " where a.especie.tipoAnimal.acronimo = :acro"
				+ " group by d";
		Query query = super.getEntityManager().createQuery(sql);
		query.setParameter("acro", acronimo);

		@SuppressWarnings("unchecked")
		List<Dono> retorno = query.getResultList();
		return retorno;
	}

	public Dono findEager(Integer id) {
		String sql = "select d from Dono d " + " inner join fetch d.animais" + " where d.id = :idDono";
		TypedQuery<Dono> query = super.getEntityManager().createQuery(sql, Dono.class);
		query.setParameter("idDono", id);
		try {
			Dono retorno = query.getSingleResult();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}

}