package com.AssinmentWeb;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Q13")
public class Q13 extends HttpServlet {
	
    // Called once when the servlet is first loaded into memory
    @Override
    public void init() throws ServletException {
        System.out.println(" Servlet Initialized: init() called");
    }

    // Handles both GET and POST requests
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Request received: service() called");
        super.service(req, res);
    }

    // Handles GET requests
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(" Handling GET request: doGet() called");
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Hello, Servlet Life Cycle Demo!</h2>");
    }

    // Handles POST requests
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(" Handling POST request: doPost() called");
        doGet(req, res);  // Reuse doGet() for response
    }

    // Called when the servlet is being removed from memory
    @Override
    public void destroy() {
        System.out.println(" Servlet Destroyed: destroy() called");
    }

}
