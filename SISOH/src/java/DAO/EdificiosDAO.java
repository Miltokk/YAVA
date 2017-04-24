/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Edificio;
import Integracion.NewHibernateUtil;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Miltokk
 */
public class EdificiosDAO <T> implements InterfaceDAO<Object>{
    
       
    private Class<T> objeto;
    public EdificiosDAO(){
        
    }

    public void setObjeto(Class<T> objeto) {
        this.objeto = objeto;
    }

    public Class<T> getObjeto() {
        return objeto;
    }
      
  

    @Override
    public List<Edificio> mostrarEdificios() {
        Session session = null;
        List<Edificio> lista = null;

        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Edificio");
            lista = (List<Edificio>) query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public void modificarEdificio(Edificio edificio) {
         Session session = null;
        
        try{
        
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(edificio);
            session.getTransaction().commit();            
            
        }catch(HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            if(session != null)
                session.close();
        }
    }

    @Override
    public void insertarEdificio(Edificio edificio) {
        Session session = null;

        try {

            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(edificio);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void eliminarEdificio(Edificio edificio) {
        Session session = null;
        
        try{
        
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(edificio);
            session.getTransaction().commit();            
            
        }catch(HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            if(session != null)
                session.close();
        }
    }

  
    
    
}
