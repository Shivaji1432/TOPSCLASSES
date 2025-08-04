package control;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	ServletContext cx=req.getServletContext();
	String url=cx.getInitParameter("url");
	PrintWriter pw=resp.getWriter();
	pw.write("<h1>"+url+"</h1>");
	ServletConfig cf=getServletConfig();
	String path=cf.getInitParameter("path");
	pw.write("<h1>"+path+"</h1>");
}
}
