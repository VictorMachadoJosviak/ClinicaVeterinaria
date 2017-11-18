package com.up.clinicaveterinaria.converter;



import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.up.clinicaveterinaria.facade.FuncionarioFacade;
import com.up.clinicaveterinaria.model.Funcionario;
import com.up.clinicaveterinaria.util.PropertiesUtil;

public class FuncionarioConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
			return null;

		try {
			Long idFuncionario = Long.parseLong(value);
			Funcionario d = (new FuncionarioFacade()).find(idFuncionario);
			return d;
		} catch (Exception e) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
					PropertiesUtil.getInstance().get("msgFalhaConversaoFuncionario"),
					PropertiesUtil.getInstance().get("msgFalhaConversaoFuncionario")));// logar
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return "";
		try {
			Funcionario f = (Funcionario) value;
			return f.getId().toString();
		} catch (Exception e) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
					PropertiesUtil.getInstance().get("msgFalhaConversaoFuncionario"),
					PropertiesUtil.getInstance().get("msgFalhaConversaoFuncionario")));// logar
		}
	}
}