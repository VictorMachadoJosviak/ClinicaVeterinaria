package com.up.clinicaveterinaria.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.up.clinicaveterinaria.dao.GenericDAO;

@WebListener
public class ServerListener implements ServletContextListener {

      public void contextInitialized(ServletContextEvent event) {
          //fazer algo quando o servidor é iniciado
      }

      public void contextDestroyed(ServletContextEvent event) {
    	  System.out.println("Fechando o EntityManagerFactory");//colocar em log
    	  try {
    		  GenericDAO.fecharEntityManagerFactory();
    	  }catch(Exception e) {
    		  e.printStackTrace();//log!
    	  }
      }
}