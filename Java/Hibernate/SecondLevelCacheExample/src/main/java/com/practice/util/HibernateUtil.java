package com.practice.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public enum HibernateUtil {
	INSTANCE;

	private SessionFactory sessionFactory;

	private HibernateUtil() {
		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
