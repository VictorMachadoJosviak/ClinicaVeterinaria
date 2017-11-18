package com.up.clinicaveterinaria.mb;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.up.clinicaveterinaria.model.Funcionario;

public class UserMB {

	private Funcionario funcionario;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String logOut() {
		HttpServletRequest  request = (HttpServletRequest) FacesContext.getCurrentInstance()
					.getExternalContext().getRequest();
		request.getSession().invalidate();
		return "/pages/public/login.xhtml";
	}
}