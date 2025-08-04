package com.AssinmentWeb;




import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/headers")
public class  Q7  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set custom response headers
        response.setHeader("Custom-Header", "HeaderServletExample");
        response.setHeader("Powered-By", "Java Servlet");

        // Set content type
        response.setContentType("text/html");

        // Prepare response writer
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>HTTP Request Headers</h2>");
        out.println("<table border='1'><tr><th>Header Name</th><th>Header Value</th></tr>");

        // Get all request headers
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<tr><td>" + headerName + "</td><td>" + headerValue + "</td></tr>");
        }

        out.println("</table>");
        out.println("<h3>Custom Headers Sent in Response:</h3>");
        out.println("<p>Custom-Header: HeaderServletExample</p>");
        out.println("<p>Powered-By: Java Servlet</p>");
        out.println("</body></html>");
    }
}
