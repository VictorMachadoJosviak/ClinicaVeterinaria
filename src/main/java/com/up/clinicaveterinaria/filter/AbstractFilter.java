package com.up.clinicaveterinaria.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractFilter {

	protected void doLogin(ServletRequest request, ServletResponse response,
					 HttpServletRequest req) throws ServletException, IOException {
			RequestDispatcher rd = req.getRequestDispatcher("/pages/public/login.xhtml");
			rd.forward(request, response);
	}
}