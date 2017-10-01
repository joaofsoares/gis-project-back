package com.gis.project.persistence;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionPersistence {
    public static Session getSession() {

        return new Configuration().configure().buildSessionFactory().openSession();

    }
}