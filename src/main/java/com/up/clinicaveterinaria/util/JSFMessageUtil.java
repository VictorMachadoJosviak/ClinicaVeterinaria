package com.up.clinicaveterinaria.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JSFMessageUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(JSFMessageUtil.class);
	
	private static final String CABECALHO_INFO = "Informação";
	private static final String CABECALHO_AVISO = "Aviso";
	private static final String CABECALHO_ERRO = "Erro";
	
	public static void sendInfoMessageToUser(String message) {
		JSFMessageUtil.sendInfoMessageToUser(CABECALHO_INFO,message);
	}
	
	public static void sendInfoMessageToUser(String title, String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, title, message);
		addMessageToJsfContext(facesMessage);
	}
	
	public static void sendWarningMessageToUser(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_WARN, CABECALHO_AVISO , message);
		addMessageToJsfContext(facesMessage);
	}

	public static void sendErrorMessageToUser(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, CABECALHO_ERRO , message);
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("erroRequest", true);
		
		addMessageToJsfContext(facesMessage);
	}

	public static void sendErrorMessageToUser(String message, Throwable exception) {
		LOG.error(message, exception);

		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, 		PropertiesUtil.getInstance().get("msgCabecalhoErro") , message);
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("erroRequest", true);

		addMessageToJsfContext(facesMessage);
	}
	
	private static FacesMessage createMessage(Severity severity, String sumario, String mensagemErro) {
		return new FacesMessage(severity, sumario, mensagemErro);
	}

	private static void addMessageToJsfContext(FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
}