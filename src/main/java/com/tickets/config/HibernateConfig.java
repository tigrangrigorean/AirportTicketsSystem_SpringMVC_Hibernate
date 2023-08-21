package com.tickets.config;

import org.hibernate.SessionFactory;

public class HibernateConfig {
	
	private HibernateConfig() {

	}
	
	private static HibernateConfig instance;
	private static org.hibernate.cfg.Configuration config;
	private static SessionFactory sessionFactory;
	
	/**
	 * Method for gets instance of Configurations class. SINGLETON
	 * @return
	 */
	public static HibernateConfig getInstance() {
		if(instance == null) {
			instance = new HibernateConfig();
			return instance;
		}else {
			return instance;
		}
	}
	
	/**
	 * Method return Configuration
	 * @return
	 */
	public static org.hibernate.cfg.Configuration getConfiguration() {
		if(config == null) {
			config = new org.hibernate.cfg.Configuration().configure();
			return config;
		}else {
			return config;
		}
	}
	
	/**
	 * Method closes Configurations
	 */
	public static void closeConfiguration() {
		if(config != null) {
			config = null;
		}
	}
	
	/**
	 * Method gets Session Factory
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			sessionFactory = config.buildSessionFactory();
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
	
	/**
	 * Method closes SessionFactory
	 */
	public static void closeSessionFactory() {
		if(sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
