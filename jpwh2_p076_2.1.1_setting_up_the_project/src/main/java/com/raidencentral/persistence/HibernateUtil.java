package com.raidencentral.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raidencentral.hello.Message;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	public final static int CONFIGURATION_TYPE_XML = 1;
	public final static int CONFIGURATION_TYPE_PROGRAMMATIC = 2;
	public final static int CONFIGURATION_TYPE_DOT_PROPERTIES = 3;

	public static void buildSessionFactory(int configurationType) {
		try {
			Configuration cfg = null;
			switch (configurationType) {
			case CONFIGURATION_TYPE_XML:
				// Create the SessionFactory from hibernate.cfg.xml (automatic configuration file detection)
				cfg = new Configuration().configure();
				break;
			case CONFIGURATION_TYPE_PROGRAMMATIC:
				cfg = new Configuration();
				cfg
				.addClass(Message.class)
					.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")//
					.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3307/jpwh2_p076_2.1.1_setting_up_the_project")//
					.setProperty("hibernate.connection.usernamne", "root")//
					.setProperty("hibernate.connection.password", "root")//
					.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect")//
					
					.setProperty("hibernate.c3p0.min_size", "5")//
					.setProperty("hibernate.c3p0.max_size", "20")//
					.setProperty("hibernate.c3p0.timeout", "300")//
					.setProperty("hibernate.c3p0.max_statements", "50")//
					.setProperty("hibernate.c3p0.idle_test_period", "3000")//
					.setProperty("show_sql", "true")//
					.setProperty("format_sql", "true")//
					.setProperty("use_sql_comments", "true")//
					.setProperty("generate_statistics", "true")//
					.setProperty("hbm2ddl.auto", "create-drop")//
					;
				break;
			case CONFIGURATION_TYPE_DOT_PROPERTIES:
				cfg = new Configuration();
				cfg.addClass(Message.class);
				break;
			default:
				break;
			}
			sessionFactory = cfg.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() throws Exception {
		if(sessionFactory==null){
			throw new Exception("sessionFactory is null");
		}
		return sessionFactory;
	}

	public static void shutdown() throws Exception {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
