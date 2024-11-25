package com.tka.utility;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Candidate;
public class ElectionUtility {
	private static SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.configure(); 
            cfg.addAnnotatedClass(Candidate.class); 
            sessionFactory = cfg.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("SessionFactory initialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

}
