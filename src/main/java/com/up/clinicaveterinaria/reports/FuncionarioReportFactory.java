package com.up.clinicaveterinaria.reports;

import java.util.ArrayList;
import java.util.List;

import com.up.clinicaveterinaria.model.Funcionario;

//ATENÇÃO: ESSA CLASSE SERVIRÁ SOMENTE PARA NOSSOS TESTES
public class FuncionarioReportFactory {

	public static List<Funcionario> createBeanCollection(){
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for(int i =0; i < 10; i++) {
			Funcionario f = new Funcionario();
			f.setNome("Funcionario " + i);
			f.setCpf((long)i);
			funcionarios.add(f);
		}
		return funcionarios;
	}
}