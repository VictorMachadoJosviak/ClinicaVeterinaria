package com.up.clinicaveterinaria.converter;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.up.clinicaveterinaria.facade.DonoFacade;
import com.up.clinicaveterinaria.model.Dono;
import com.up.clinicaveterinaria.util.PropertiesUtil;

public class DonoConverter implements Converter, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.isEmpty())
			return null;
		
		try{
			Integer idDono = Integer.parseInt(value);		
			Dono d = (new DonoFacade()).find(idDono);
			return d;
		}catch(Exception e){
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						PropertiesUtil.getInstance().get("msgFalhaConversaoDono"),
						PropertiesUtil.getInstance().get("msgFalhaConversaoDono")));
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if(value==null)
			return "";
		try{
			Dono dono = (Dono)value; 
			return dono.getId().toString();
		}catch(Exception e){
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						PropertiesUtil.getInstance().get("msgFalhaConversaoDono"),
						PropertiesUtil.getInstance().get("msgFalhaConversaoDono")));
		}
	}

}
