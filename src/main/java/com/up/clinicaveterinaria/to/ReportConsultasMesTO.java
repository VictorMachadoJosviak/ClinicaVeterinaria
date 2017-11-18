package com.up.clinicaveterinaria.to;

import java.util.Date;

public class ReportConsultasMesTO {
	
	private Date mesReferencia;
	private Integer numConsultas;
	
	public ReportConsultasMesTO(Date mesReferencia, Integer numConsultas) {
		this.mesReferencia = mesReferencia;
		this.numConsultas = numConsultas;
	}
	
	public Date getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(Date mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	public Integer getNumConsultas() {
		return numConsultas;
	}
	public void setNumConsultas(Integer numConsultas) {
		this.numConsultas = numConsultas;
	}
}