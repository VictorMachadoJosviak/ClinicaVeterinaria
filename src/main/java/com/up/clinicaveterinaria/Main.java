package com.up.clinicaveterinaria;

import com.up.clinicaveterinaria.dao.GenericDAO;
import com.up.clinicaveterinaria.facade.AnimalFacade;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.util.PasswordEncoder;

public class Main {
	
	private static final String CONSTANTE_SAL = "xlkjq";
	
	public static void main(String[] args) {
		
		try {
			PasswordEncoder enc = new PasswordEncoder();
			Long cpf = 8980L;
			String hash;
			hash = enc.codificar("1234", CONSTANTE_SAL + cpf.toString());
			System.out.println(hash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}