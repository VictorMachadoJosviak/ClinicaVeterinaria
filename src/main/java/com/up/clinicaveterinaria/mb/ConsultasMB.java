package com.up.clinicaveterinaria.mb;

import java.util.Date;
import java.util.List;

import com.up.clinicaveterinaria.facade.FuncionarioFacade;
import com.up.clinicaveterinaria.model.Funcionario;
import com.up.clinicaveterinaria.util.DataHoraUtil;

public class ConsultasMB {
	
	private List<Funcionario> veterinarios;
	private Funcionario veterinarioSelecionado;
	private Date diaConsultas;
	
	public ConsultasMB() {
		try {
			diaConsultas = DataHoraUtil.getDiaAtual();
			veterinarioSelecionado = null;
			veterinarios = (new FuncionarioFacade()).listarVeterinarios();
		}catch(Exception e) {
			e.printStackTrace();//logar
		}
	}

	public Funcionario getVeterinarioSelecionado() {
		return veterinarioSelecionado;
	}

	public void setVeterinarioSelecionado(Funcionario veterinarioSelecionado) {
		this.veterinarioSelecionado = veterinarioSelecionado;
	}

	public List<Funcionario> getVeterinarios() {
		return veterinarios;
	}

	public Date getDiaConsultas() {
		return diaConsultas;
	}

	public void setDiaConsultas(Date diaConsultas) {
		this.diaConsultas = diaConsultas;
		System.out.println(diaConsultas);
	}
}