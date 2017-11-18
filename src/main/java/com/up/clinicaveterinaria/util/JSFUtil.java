package com.up.clinicaveterinaria.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JSFUtil implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public void enviarArquivoDownload(String nomeArquivo, byte[] bytes,
			MimeType mimeType) throws IOException {
	    FacesContext fc = FacesContext.getCurrentInstance();
	    ExternalContext ec = fc.getExternalContext();

	    if(!nomeArquivo.contains("."))
	    	nomeArquivo = nomeArquivo + "." + mimeType.getMimeType();
	    
	    ec.responseReset(); // Limpando filtros
	    ec.setResponseContentType(mimeType.getContentType()); 
	    ec.setResponseContentLength(bytes.length);
	    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + nomeArquivo + "\"");

	    OutputStream output = ec.getResponseOutputStream();
	    output.write(bytes);

	    fc.responseComplete();
	}
	
	public static String getRealPath(String pathRelativo){
		ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
		return ctx.getRealPath(pathRelativo);
	}
	
	public void enviarRelatorioPDFJasper(List<?> listaBeans, String nomeArquivoRelatorio,
			String pathRelatorio, Map<String, Object> parametros) throws Exception
	{
		JRDataSource beanDS = new JRBeanCollectionDataSource(listaBeans);
		JasperPrint print = JasperFillManager.fillReport(pathRelatorio,	parametros, beanDS);
		byte[] relatorioBinary = JasperExportManager.exportReportToPdf(print);
		this.enviarArquivoDownload(nomeArquivoRelatorio, relatorioBinary, MimeType.PDF);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
	    T bean = null;
	    FacesContext fc = FacesContext.getCurrentInstance();
	    if(fc != null) {
	         ELContext elContext = fc.getELContext();
	         bean = (T) elContext.getELResolver().getValue(elContext, null, beanName);
	    }
	    return bean;
	}
}