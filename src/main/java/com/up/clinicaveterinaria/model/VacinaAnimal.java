package com.up.clinicaveterinaria.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="vacina_animal")
public class VacinaAnimal {
	
	@EmbeddedId
	private VacinaAnimalID vacinaAnimalID;
	private String descricaoVeterinario;
	
	public VacinaAnimalID getVacinaAnimalID() {
		return vacinaAnimalID;
	}

	public void setVacinaAnimalID(VacinaAnimalID vacinaAnimalID) {
		this.vacinaAnimalID = vacinaAnimalID;
	}
	
	public Animal getAnimal() {
		return vacinaAnimalID.getAnimal();
	}

	public void setAnimal(Animal animal) {
		vacinaAnimalID.setAnimal(animal);
	}

	public Vacina getVacina() {
		return vacinaAnimalID.getVacina();
	}

	public void setVacina(Vacina vacina) {
		vacinaAnimalID.setVacina(vacina);
	}

	public Date getDataVacinacao() {
		return vacinaAnimalID.getDataVacinacao();
	}

	public void setDataVacinacao(Date dataVacinacao) {
		vacinaAnimalID.setDataVacinacao(dataVacinacao);
	}

	public String getDescricaoVeterinario() {
		return descricaoVeterinario;
	}
	
	public void setDescricaoVeterinario(String descricaoVeterinario) {
		this.descricaoVeterinario = descricaoVeterinario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vacinaAnimalID == null) ? 0 : vacinaAnimalID.hashCode());
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
		VacinaAnimal other = (VacinaAnimal) obj;
		if (vacinaAnimalID == null) {
			if (other.vacinaAnimalID != null)
				return false;
		} else if (!vacinaAnimalID.equals(other.vacinaAnimalID))
			return false;
		return true;
	}
	
}
