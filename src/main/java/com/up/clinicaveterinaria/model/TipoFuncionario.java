package com.up.clinicaveterinaria.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo_funcionario")
public class TipoFuncionario {
	@Id
	private String codigoTipo;
	private String descricao;
	
	@OneToMany(mappedBy="tipoFuncionario")
	private List<Funcionario> funcionarios;
	
	public String getCodigoTipo() {
		return codigoTipo;
	}
	
	public void setCodigoTipo(String codigoTipo) {
		this.codigoTipo = codigoTipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTipo == null) ? 0 : codigoTipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoFuncionario other = (TipoFuncionario) obj;
		if (codigoTipo == null) {
			if (other.codigoTipo != null)
				return false;
		} else if (!codigoTipo.equals(other.codigoTipo))
			return false;
		return true;
	}
}