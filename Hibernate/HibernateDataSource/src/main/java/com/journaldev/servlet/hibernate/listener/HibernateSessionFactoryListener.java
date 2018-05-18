package com.journaldev.servlet.hibernate.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;

@WebListener
public class HibernateSessionFactoryListener implements ServletContextListener {

	public final Logger logger = Logger.getLogger(HibernateSessionFactoryListener.class);
	
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	SessionFactory sessionFactory = (SessionFactory) servletContextEvent.getServletContext().getAttribute("SessionFactory");
    	if(sessionFactory != null && !sessionFactory.isClosed()){
    		logger.info("Closing sessionFactory");
    		sessionFactory.close();
    	}
    	logger.info("Released Hibernate sessionFactory resource");
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	logger.info("Hibernate Configuration created successfully");
    	
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    	logger.info("ServiceRegistry created successfully");
    	SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);
    	logger.info("SessionFactory created successfully");
    	
    	servletContextEvent.getServletContext().setAttribute("SessionFactory", sessionFactory);
    	logger.info("Hibernate SessionFactory Configured successfully");
    }
	
}
