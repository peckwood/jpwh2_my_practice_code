package com.raidencentral.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raidencentral.hello.Message;

public class HibernateUtilProgrammaticConfiguration {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			// Create the SessionFactory from hibernate.cfg.xml
			cfg.addClass(Message.class).setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver")
					.setProperty("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost")
					.setProperty("hibernate.connection.usernamne", "sa")
					.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
					.setProperty("hibernate.c3p0.min_size", "5").setProperty("hibernate.c3p0.max_size", "20")
					.setProperty("hibernate.c3p0.timeout", "300").setProperty("hibernate.c3p0.max_statements", "50")
					.setProperty("hibernate.c3p0.idle_test_period", "3000").setProperty("show_sql", "true")
					.setProperty("format_sql", "true").setProperty("use_sql_comments", "true")
					.setProperty("generate_statistics", "true").setProperty("hbm2ddl.auto", "create-drop");
			return cfg.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
