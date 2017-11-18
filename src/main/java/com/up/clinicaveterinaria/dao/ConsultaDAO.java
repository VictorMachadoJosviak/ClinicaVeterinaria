package com.up.clinicaveterinaria.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.up.clinicaveterinaria.model.Consulta;
import com.up.clinicaveterinaria.model.ConsultaId;
import com.up.clinicaveterinaria.to.ReportConsultasMesTO;

public class ConsultaDAO extends GenericDAO<ConsultaId, Consulta>{
	public ConsultaDAO() {
		super(Consulta.class);
	}
	
	public List<ReportConsultasMesTO> listConsultasMes(){
		String sql = "select TRUNC(dataHora_consulta, 'MONTH') as mes,"
				+ " count(*) from consulta group by mes";
		Query query = super.getEntityManager().createNativeQuery(sql);

		@SuppressWarnings("unchecked")
		List<Object[]> objetos = query.getResultList();
		List<ReportConsultasMesTO> retorno = new
					ArrayList<ReportConsultasMesTO>(objetos.size());
		for(Object obj[] : objetos)
			retorno.add(new ReportConsultasMesTO((Date)obj[0],
				((BigInteger)obj[1]).intValue()));
		return retorno;
	}
}