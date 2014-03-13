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
    //persist
    public static void persist( Horoscope h)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(h);
    }
    //recherche
	//par id
    public static Horoscope getHoroscopeById( long id )
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        //Query q = em.createQuery("select h from Horoscope h where h.id = :id");
        //q.setParameter("id", id );
        //return (Horoscope) q.getSingleResult();
        return em.find(Horoscope.class,id);
    }
	//toutes les horoscopes 
	public List<Horoscope> getAllHoroscope() {
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery("SELECT h from Horoscope h");
        List<Horoscope> horoscopes = (List<Horoscope>) q.getResultList();
        return horoscopes;
    }
	//par client 
	public List<Horoscope> getHoroscopesByClient(Client c) {
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery("SELECT h from Horoscope h WHERE h.client.id = "
                + c.getId());
        List<Horoscope> horoscopes = (List<Horoscope>) q.getResultList();
        return horoscopes;
    }
	
	
	
	
}
