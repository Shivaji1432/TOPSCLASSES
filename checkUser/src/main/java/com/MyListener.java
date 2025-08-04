package com;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener {

		int cuser = 0;
		int tuser = 0;
		@Override
		public void sessionCreated(HttpSessionEvent se) {
		//	System.out.println("session created");
			cuser++;
			tuser++;
			System.out.println(cuser+" "+tuser);
			ServletContext cx = se.getSession().getServletContext();
			cx.setAttribute("cuser", cuser+"");
			cx.setAttribute("tuser", tuser+"");
		}
		
		@Override
		public void sessionDestroyed(HttpSessionEvent se) {
	
			//System.out.println("Sesion destroyed");
			cuser--;
			System.out.println(cuser);
			ServletContext cx = se.getSession().getServletContext();
			cx.setAttribute("cuser", cuser+"");
			
			
		}
	

}
