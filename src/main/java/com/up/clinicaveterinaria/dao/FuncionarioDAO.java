package com.up.clinicaveterinaria.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.up.clinicaveterinaria.model.Funcionario;

public class FuncionarioDAO extends GenericDAO<Long, Funcionario> {

	public FuncionarioDAO() {
		super(Funcionario.class);
	}

	public Funcionario findByCPF(Long cpf) {
		Query query = super.getEntityManager().createNamedQuery("Funcionario.findBycpf");
		query.setParameter("cpf", cpf);
		try {
			Funcionario retorno = (Funcionario) query.getSingleResult();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Funcionario loginFuncionario(Long cpf, String senha) {
		try {
			Query query = super.getEntityManager().createNamedQuery("Funcionario.login");
			query.setParameter("cpf", cpf);
			query.setParameter("hash", senha);
			Funcionario retorno = (Funcionario) query.getSingleResult();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public List<Funcionario> listarByTipo(String strCodigoTipoFunc) {
		TypedQuery<Funcionario> query = super.getEntityManager().createNamedQuery("Funcionario.listarByTipo",
				Funcionario.class);
		query.setParameter("strCodigo", strCodigoTipoFunc);

		return query.getResultList();
	}
}