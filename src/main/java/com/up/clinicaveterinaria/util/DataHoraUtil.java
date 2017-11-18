package com.up.clinicaveterinaria.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class DataHoraUtil implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static Date getDiaAtual(){
		Calendar atual = Calendar.getInstance();
		atual.set(Calendar.HOUR_OF_DAY, 0);
		atual.set(Calendar.MINUTE, 0);
		atual.set(Calendar.SECOND, 0);
		atual.set(Calendar.MILLISECOND, 0);
		
		return atual.getTime();
	}
	
	public static Date getMesAtual(){
		Calendar atual = Calendar.getInstance();
		atual.set(Calendar.DAY_OF_MONTH, 1);
		atual.set(Calendar.HOUR_OF_DAY, 0);
		atual.set(Calendar.MINUTE, 0);
		atual.set(Calendar.SECOND, 0);
		atual.set(Calendar.MILLISECOND, 0);
		
		return atual.getTime();
	}
	
	public static Calendar getCalendarMesAtual(){
		Calendar atual = Calendar.getInstance();
		atual.set(Calendar.DAY_OF_MONTH, 1);
		atual.set(Calendar.HOUR_OF_DAY, 0);
		atual.set(Calendar.MINUTE, 0);
		atual.set(Calendar.SECOND, 0);
		atual.set(Calendar.MILLISECOND, 0);
		
		return atual;
	}
	
	public static Date getPrimeiroDiaMes(Date data){
		Calendar atual = Calendar.getInstance();
		atual.setTime(data);
		atual.set(Calendar.DAY_OF_MONTH, 1);
		atual.set(Calendar.HOUR_OF_DAY, 0);
		atual.set(Calendar.MINUTE, 0);
		atual.set(Calendar.SECOND, 0);
		atual.set(Calendar.MILLISECOND, 0);
		
		return atual.getTime();
	}
	
	public static Date adicionarMeses(Date data, int numMeses){
		Calendar atual = Calendar.getInstance();
		atual.setTime(data);
		atual.add(Calendar.MONTH, numMeses);
		return atual.getTime();
	}
	
	public static Calendar getPrimeiroDiaMes(Calendar calendar){
		Calendar atual = (Calendar)calendar.clone();
		atual.set(Calendar.DAY_OF_MONTH, 1);
		atual.set(Calendar.HOUR_OF_DAY, 0);
		atual.set(Calendar.MINUTE, 0);
		atual.set(Calendar.SECOND, 0);
		atual.set(Calendar.MILLISECOND, 0);
		
		return atual;
	}
	
	public static Date getUltimoInstanteMes(Date data){
		Calendar atual = Calendar.getInstance();
		atual.setTime(data);
		atual.set(Calendar.DAY_OF_MONTH, atual.getActualMaximum(Calendar.DATE));
		atual.set(Calendar.HOUR_OF_DAY, 23);
		atual.set(Calendar.MINUTE, 59);
		atual.set(Calendar.SECOND, 59);
		atual.set(Calendar.MILLISECOND, 999);
		
		return atual.getTime();
	}
	
	public static Date getUltimoInstanteMesAtual(){
		Calendar atual = Calendar.getInstance();
		atual.set(Calendar.DAY_OF_MONTH, atual.getActualMaximum(Calendar.DATE));
		atual.set(Calendar.HOUR_OF_DAY, 23);
		atual.set(Calendar.MINUTE, 59);
		atual.set(Calendar.SECOND, 59);
		atual.set(Calendar.MILLISECOND, 999);
		
		return atual.getTime();
	}
	
	public static int getDiferencaEmDias(Date dataInicial, Date dataFinal){
		return (int)( (dataFinal.getTime() - dataInicial.getTime()) 
                / (1000 * 60 * 60 * 24) );
	}
	
	public static int getDiferencaEmMeses(Date dataInicial, Date dataFinal){
		Calendar calendarInicial = Calendar.getInstance();
		calendarInicial.setTime(dataInicial);
		
		Calendar calendarFinal = Calendar.getInstance();
		calendarFinal.setTime(dataFinal);
		
		return (calendarFinal.get(Calendar.YEAR) - calendarInicial.get(Calendar.YEAR))*12 
				+ calendarFinal.get(Calendar.MONTH) - calendarInicial.get(Calendar.MONTH);  
	}
}
