package org.ass.order.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class OrderDispatcherServlet implements WebApplicationInitializer
{

	@SuppressWarnings("resource")
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException 
	{
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfiguration.class);
		
		DispatcherServlet servlet = new DispatcherServlet(context);
		
		Dynamic dynamic = servletContext.addServlet("Dispatcher", servlet);
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
		
	}
	
}
