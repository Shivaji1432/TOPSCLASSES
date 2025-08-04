package com;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener  implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("context destroyed");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("context initalized");
	}

}
