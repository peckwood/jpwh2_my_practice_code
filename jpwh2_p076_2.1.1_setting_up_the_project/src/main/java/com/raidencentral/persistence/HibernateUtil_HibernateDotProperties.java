package com.raidencentral.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raidencentral.hello.Message;

public class HibernateUtil_HibernateDotProperties {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg
			.addResource("com/raidencentral/hello/Message.hbm.xml")
				;
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
