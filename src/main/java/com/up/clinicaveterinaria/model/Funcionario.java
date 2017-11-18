package com.up.clinicaveterinaria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
@NamedQueries({
	@NamedQuery(name="Funcionario.login", query = " SELECT f FROM Funcionario f WHERE f.cpf = :cpf and f.senha = :hash" ),
	@NamedQuery(name="Funcionario.findBycpf", query = " SELECT f FROM Funcionario f WHERE f.cpf = :cpf" ),
	@NamedQuery(name="Funcionario.listarByTipo", query = " SELECT f FROM Funcionario f WHERE f.tipoFuncionario.codigoTipo = :strCodigo" )
})
public class Funcionario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String Nome;
	@Column(name="cpf",nullable=false,unique=true)
	private Long cpf;
	private Date nascimento;
	private Date dataAdmissao;
	@ManyToOne
	@JoinColumn(name="tipo_funcionario_codigotipo")
	private TipoFuncionario tipoFuncionario;	
	@Column(name="senha")
	private String senha;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public Long getCpf() {
		return cpf;
	}
	
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}