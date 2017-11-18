package com.up.clinicaveterinaria.mb;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.up.clinicaveterinaria.model.Funcionario;
import com.up.clinicaveterinaria.util.JSFUtil;

public class ReportsMB {

	public void gerarRelatorioFuncionarios() {
		JSFUtil jsfUtil = new JSFUtil();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for(int i =0; i < 10; i ++) {
			Funcionario f = new Funcionario();
			f.setNome("Funcionário" + i);
			f.setCpf((long)i);
			funcionarios.add(f);
		}
		try {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("REPORT_TIME_ZONE", Calendar.getInstance().getTimeZone());
			String pathDocumento = JSFUtil.getRealPath(File.separatorChar + "resources" 					+  File.separatorChar + "reports" + File.separatorChar
					+  "reportFuncionarios.jasper");
			jsfUtil.enviarRelatorioPDFJasper(funcionarios,
				"Arquivo.pdf", pathDocumento, parametros);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}