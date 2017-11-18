package com.up.clinicaveterinaria.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="animal")
public class Animal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Date nascimento;
	@ManyToOne
	@JoinColumn(name = "DONO_ID",nullable=false)
	private Dono dono;
	
	@OneToMany(mappedBy="consultaId.animal")
	private List<Consulta> consulta;
	
	@ManyToOne
	@JoinColumn(name = "ESPECIE_ID",nullable=false)
	private Especie especie;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="alergia_animal",
		joinColumns={@JoinColumn(name="animal_id", referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="alergia_id",referencedColumnName="id")}	)
	private List<Alergia> alergias;
	
	@OneToMany(mappedBy="vacinaAnimalID.animal", fetch=FetchType.LAZY)
	private List<VacinaAnimal> vacinasAnimal;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public Dono getDono() {
		return dono;
	}
	
	public void setDono(Dono dono) {
		this.dono = dono;
	}
	
	public Especie getEspecie() {
		return especie;
	}
	
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	public List<Alergia> getAlergias() {
		return alergias;
	}
	
	public void setAlergias(List<Alergia> alergias) {
		this.alergias = alergias;
	}
	
	public List<VacinaAnimal> getVacinasAnimal() {
		return vacinasAnimal;
	}
	
	public void setVacinasAnimal(List<VacinaAnimal> vacinasAnimal) {
		this.vacinasAnimal = vacinasAnimal;
	}
	public List<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
