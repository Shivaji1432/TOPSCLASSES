package com;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/nav")
public class NavFilter extends HttpFilter {
	String permission = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		permission = config.getServletContext().getInitParameter("permission");
	}

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (permission.equals("true")) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}
	}
}
