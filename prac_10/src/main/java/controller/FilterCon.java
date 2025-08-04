package controller;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/reg")
public class FilterCon extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String cpass = request.getParameter("cpass");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		if (name.equals("") || name.equals(null)) {
			request.setAttribute("unameerr", "Username is required");

			rd.forward(request, response);

		} 
		if (email.equals("") || email.equals(null)) {
			request.setAttribute("emailerr", "email is required");

			rd.forward(request, response);

		}else if(!Validation.checkEamil(email))
		{
			request.setAttribute("emailerr", "Invalid email format !!!");
			rd.forward(request, response);
		}
		if (pass.equals("") || pass.equals(null)) {
			request.setAttribute("passerr", "pass is required");

			rd.forward(request, response);

		}else if(!Validation.checkpass(pass))
		{
			request.setAttribute("passerr", "at least one upper-lower-digit-special charecter required");
			rd.forward(request, response);
		} 
		if (cpass.equals("") || cpass.equals(null)) {
			request.setAttribute("cpasserr", "cpass is required");
			rd.forward(request, response);

		}else if(!cpass.equals(pass))
		{
			request.setAttribute("cpasserr", "password mismatched !!!");
			rd.forward(request, response);
		}
		chain.doFilter(request, response);
	}
}
