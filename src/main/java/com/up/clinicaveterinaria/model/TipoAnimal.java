package com.up.clinicaveterinaria.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo_animal")
public class TipoAnimal {
	@Id
	private String acronimo;
	private String nome;
	private String Descricao;
	@OneToMany(mappedBy="tipoAnimal")
	private List<Especie> especies;
	
	public String getAcronimo() {
		return acronimo;
	}
	
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return Descricao;
	}
	
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public List<Especie> getEspecies() {
		return especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acronimo == null) ? 0 : acronimo.hashCode());
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
		TipoAnimal other = (TipoAnimal) obj;
		if (acronimo == null) {
			if (other.acronimo != null)
				return false;
		} else if (!acronimo.equals(other.acronimo))
			return false;
		return true;
	}	
}