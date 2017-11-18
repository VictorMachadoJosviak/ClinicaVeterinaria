package com.up.clinicaveterinaria.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.up.clinicaveterinaria.constants.Constants;
import com.up.clinicaveterinaria.exception.AssociacaoInvalidaException;

@Entity
@Table(name="consulta")
public class Consulta {
	@EmbeddedId
	private ConsultaId consultaId;
	@ManyToOne
	@JoinColumn(name="veterinario_id")
	private Funcionario veterinario;
	@ManyToOne
	@JoinColumn(name="funcionario_agend_id")
	private Funcionario responsavelAgendamento;
	
	public Consulta(){
		consultaId = new ConsultaId();
	}
	
	public ConsultaId getConsultaId() {
		return consultaId;
	}

	public void setConsultaId(ConsultaId consultaId) {
		this.consultaId = consultaId;
	}

	public Animal getAnimal() {
		return consultaId.getAnimal();
	}

	public void setAnimal(Animal animal) {
		consultaId.setAnimal(animal);
	}

	public Date getDataHoraConsulta() {
		return consultaId.getDataHoraConsulta();
	}

	public void setDataHoraConsulta(Date dataHoraConsulta) {
		consultaId.setDataHoraConsulta(dataHoraConsulta);
	}

	public Funcionario getVeterinario() {
		return veterinario;
	}
	
	public void setVeterinario(Funcionario veterinario) throws AssociacaoInvalidaException {
		if(veterinario != null && veterinario.getTipoFuncionario() != null && 
				!veterinario.getTipoFuncionario()
					.equals(Constants.CODIGO_TIPO_FUNCIONARIO_VETERINARIO))
			throw new AssociacaoInvalidaException(this, veterinario);
		else
			this.veterinario = veterinario;
	}
	
	public Funcionario getResponsavelAgendamento() {
		return responsavelAgendamento;
	}
	
	public void setResponsavelAgendamento(Funcionario responsavelAgendamento) {
		this.responsavelAgendamento = responsavelAgendamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consultaId == null) ? 0 : consultaId.hashCode());
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
		Consulta other = (Consulta) obj;
		if (consultaId == null) {
			if (other.consultaId != null)
				return false;
		} else if (!consultaId.equals(other.consultaId))
			return false;
		return true;
	}
}
