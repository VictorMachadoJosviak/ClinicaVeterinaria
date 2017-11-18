package com.up.clinicaveterinaria.exception;

public class AssociacaoInvalidaException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private Object objeto1;
	private Object objeto2;

	public AssociacaoInvalidaException(Object objeto1, Object objeto2) {
		this(objeto1, objeto2, "");
	}
	
	public AssociacaoInvalidaException(Object objeto1, Object objeto2, String message) {
		super("Impossível associar " + objeto1.getClass() + " com " +  objeto2.getClass() + ". "  + message);
	}

	public Object getObjeto1() {
		return objeto1;
	}

	public Object getObjeto2() {
		return objeto2;
	}
}