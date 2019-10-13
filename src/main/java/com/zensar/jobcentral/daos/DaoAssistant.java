package com.zensar.jobcentral.daos;

/**
 * @author Gourab Sarkar
 * @modification_date 13 Oct 2019 19:57
 * @creation_date 13 Oct 2019 19:57
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the DaoAssistant class which contains methods relating to Session, configuration and Transaction objects
 *              This class exists because HibernateTemplate has been deprecated and should not be used.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoAssistant
{

    private static Configuration configuration = new Configuration().configure();
    private static SessionFactory sessionFactory = configuration.buildSessionFactory();
    private static Session session = sessionFactory.openSession();

    public static Session getCurrentSession()
    {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        return session;
    }

    protected void beginTx()
    {
        getCurrentSession().beginTransaction();
    }

    protected void commitTransaction()
    {
        getCurrentSession().getTransaction().commit();
    }

    protected void rollbackTransaction()
    {
        try 
        {
            getCurrentSession().getTransaction().rollback();
            System.out.println("Debug: Transaction rollback successful.");
        }
        catch (Exception exc)
        {
            System.err.println("Whoops! Cannot rollback transaction.");
        }

        try 
        {
            getCurrentSession().close();
            System.out.println("Debug: Session close successful.");
            session = null;
        }
        catch (Exception exc)
        {
            System.err.println("Whoops! Cannot close session.");
        }
    }

    public static void closeSession()
    {
        try 
        {
            getCurrentSession().close();
            System.out.println("Debug: Session close successful.");
            session = null;
        }
        catch (Exception exc) 
        {
            System.err.println("Whoops! Cannot close session.");
        }
    }

}