/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import metier.modele.Horoscope;


/**
 *
 * @author Administrateur
 */
public class HoroscopeDao {
    
    public static void persist( Horoscope h)
    {
        EntityManager em = dao.JpaUtil.obtenirEntityManager();
        em.persist(h);
    }
    
    public static Horoscope getHoroscopeById( long id )
    {
        EntityManager em = dao.JpaUtil.obtenirEntityManager();
        //Query q = em.createQuery("select h from Horoscope h where h.id = :id");
        //q.setParameter("id", id );
        //return (Horoscope) q.getSingleResult();
        return em.find(Horoscope.class,id);
    }
}
