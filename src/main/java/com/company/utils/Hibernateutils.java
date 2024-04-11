package com.company.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.company.entity.Group;

@SuppressWarnings("rawtypes")
public class Hibernateutils {
	
	private static Class[] entitties = new Class[] {Group.class};
	
	private static Hibernateutils instance;
	
	private Configuration configuration;
	private SessionFactory sessionFactory;
	
	public static Hibernateutils getInstance() {
		if(null == instance) {
			instance = new Hibernateutils();
		}
		return instance;
	}
	
	private Hibernateutils() {
		configure();
	}

	private void configure() {
		// load configuration
		configuration =  new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		// add entity
		for(Class entity: entitties) {
			configuration.addAnnotatedClass(entity);
		}
		
	}
	
	private SessionFactory buildSessionFactory () {
		if(null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		
		return sessionFactory;
	}
	
	private void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}
	
	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

}
