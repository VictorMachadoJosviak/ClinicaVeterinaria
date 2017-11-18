package com.up.clinicaveterinaria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VacinaAnimalID implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "animal_id", referencedColumnName = "id")
	private Animal animal;
	@ManyToOne
	@JoinColumn(name = "vacina_id", referencedColumnName = "id")
	private Vacina vacina;
	private Date dataVacinacao;
	
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Vacina getVacina() {
		return vacina;
	}
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	public Date getDataVacinacao() {
		return dataVacinacao;
	}
	public void setDataVacinacao(Date dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + ((dataVacinacao == null) ? 0 : dataVacinacao.hashCode());
		result = prime * result + ((vacina == null) ? 0 : vacina.hashCode());
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
		VacinaAnimalID other = (VacinaAnimalID) obj;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (dataVacinacao == null) {
			if (other.dataVacinacao != null)
				return false;
		} else if (!dataVacinacao.equals(other.dataVacinacao))
			return false;
		if (vacina == null) {
			if (other.vacina != null)
				return false;
		} else if (!vacina.equals(other.vacina))
			return false;
		return true;
	}
}
