package com.up.clinicaveterinaria.facade;

import java.util.List;

import com.up.clinicaveterinaria.constants.Constants;
import com.up.clinicaveterinaria.dao.FuncionarioDAO;
import com.up.clinicaveterinaria.model.Funcionario;
import com.up.clinicaveterinaria.util.JSFMessageUtil;
import com.up.clinicaveterinaria.util.PasswordEncoder;

public class FuncionarioFacade extends GenericFacade<Long, Funcionario, FuncionarioDAO>{

	private static final String CONSTANTE_SAL = "LOL";
	
	public FuncionarioFacade() {
		super(new FuncionarioDAO());
	}
	
	public Funcionario findByCpf(Long cpf) throws Exception {
		try {
			dao.beginTransaction();
			Funcionario obj = dao.findByCPF(cpf);
			dao.commitAndCloseTransaction();
			return obj;
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public Funcionario login(Long cpf,String senha) {
		
		try {			
			PasswordEncoder enc = new PasswordEncoder();			
			String hash = enc.codificar(senha, CONSTANTE_SAL + cpf.toString());			
			dao.beginTransaction();
			Funcionario obj = dao.loginFuncionario(cpf, hash);
			dao.commitAndCloseTransaction();
			return obj;
			
		} catch (Exception e) {		
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			return null;						
		}
		
	}
	
	public List<Funcionario> listarVeterinarios() throws Exception {
		return listarByTipo(Constants.CODIGO_TIPO_FUNCIONARIO_VETERINARIO);
	}
	
	public List<Funcionario> listarByTipo(String strCodigoTipoFunc) throws Exception {
		try {
			dao.beginTransaction();
			List<Funcionario> lista = dao.listarByTipo(strCodigoTipoFunc);
			dao.commitAndCloseTransaction();
			return lista;
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}