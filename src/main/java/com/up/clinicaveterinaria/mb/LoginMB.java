package com.up.clinicaveterinaria.mb;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.up.clinicaveterinaria.facade.FuncionarioFacade;
import com.up.clinicaveterinaria.model.Funcionario;
import com.up.clinicaveterinaria.model.TipoFuncionario;
import com.up.clinicaveterinaria.util.JSFMessageUtil;
import com.up.clinicaveterinaria.util.PropertiesUtil;

public class LoginMB {
	
	private FuncionarioFacade funcionarioFacade = new FuncionarioFacade();
	
	private Long cpf;
	private UserMB userMB;
	private String senha;
		
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public UserMB getUserMB() {
		return userMB;
	}

	public void setUserMB(UserMB userMB) {
		this.userMB = userMB;
	}

	public String login() {
		try{
			if(cpf != null) {
				Funcionario f = funcionarioFacade.login(cpf, senha);
				if(f!=null) {
					userMB.setFuncionario(f);
					
					FacesContext context = FacesContext.getCurrentInstance();
					HttpServletRequest request = (HttpServletRequest)
						 context.getExternalContext().getRequest();
					request.getSession().setAttribute("user", f);
					
					return NavegacaoMB.VAI_PARA_INDEX;
				}else {
					JSFMessageUtil.sendWarningMessageToUser(
							PropertiesUtil.getInstance().get("avsDadosLoginIncorretos"));
				}
			}else {
				JSFMessageUtil.sendWarningMessageToUser(
						PropertiesUtil.getInstance().get("avsDadosLoginIncorretos"));
			}
		}catch(Exception e){
			e.printStackTrace();//LOGAR!
			JSFMessageUtil.sendWarningMessageToUser(
					PropertiesUtil.getInstance().get("avsErroGenericoAplicacao"));
		}
		return null;
	}
}