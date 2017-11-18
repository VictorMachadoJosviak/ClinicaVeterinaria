package com.up.clinicaveterinaria.facade;

import java.util.List;

import com.up.clinicaveterinaria.dao.ConsultaDAO;
import com.up.clinicaveterinaria.model.Consulta;
import com.up.clinicaveterinaria.model.ConsultaId;
import com.up.clinicaveterinaria.to.ReportConsultasMesTO;

public class ConsultaFacade extends GenericFacade<ConsultaId, Consulta,ConsultaDAO>{

	public ConsultaFacade() {
		super(new ConsultaDAO());
	}
	
	public List<ReportConsultasMesTO> listConsultasMes(){
		try {
			dao.beginTransaction();
			List<ReportConsultasMesTO> lista = dao.listConsultasMes();
			dao.commitAndCloseTransaction();
			return lista;
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}