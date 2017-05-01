/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Salon;
import Entidad.Unidadacademica;
import Integracion.NewHibernateUtil;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

;

/**
 *
 * @author Angel
 */
public class SalonesDAO<T> implements InterfaceDAOSalon {

    private Class<T> objeto;

    public SalonesDAO() {

    }

    public void setObjeto(Class<T> objeto) {
        this.objeto = objeto;
    }

    public Class<T> getObjeto() {
        return objeto;
    }

    @Override
    public List<Salon> mostrarSalon() {
        Session session = null;
        List<Salon> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Salon");
            lista = (List<Salon>) query.list();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            return lista;
        }
    }

    @Override
    public Salon buscarSalon(int id) {
        Session session = null;
        Salon resul = null;
        try {
            NewHibernateUtil.getSession();
            NewHibernateUtil.beingTransaccion();
            resul=(Salon)NewHibernateUtil.getSession().createQuery("from Salon as salon where salon.salonId = :id").setString("id", String.valueOf(id)).uniqueResult();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            return resul;
        }
    }

    @Override
    public void modificarSalon(Salon sala) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(sala);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void insertarSalon(Salon sala) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sala);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void eliminarSalon(Salon sala) {
        Session session = null;
        List<Salon> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(sala);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
