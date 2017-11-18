package com.up.clinicaveterinaria.mb;

public class NavegacaoMB {

	public static final String VAI_PARA_INDEX = "index";
	public static final String VAI_PARA_CADASTRO_ANIMAIS = "cadastroAnimais";
	public static final String VAI_PARA_CONSULTAS = "consultas";
	public static final String VAI_PARA_RELATORIOS = "relatorios";

	public String getVaiParaIndex() {// um get para ser acessível a partir das páginas xhtml. Não deve ser estático
		return VAI_PARA_INDEX;
	}
	
	public String getVaiParaRelatorios() {
		return VAI_PARA_RELATORIOS;
	}

	public String getVaiParaCadastroAnimais() {
		return VAI_PARA_CADASTRO_ANIMAIS;
	}

	public String getVaiParaConsultas() {
		return VAI_PARA_CONSULTAS;
	}
}