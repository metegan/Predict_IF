/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Signe;

/**
 *
 * @author Administrateur
 */
public class SigneDao {
    
	//persist   
    public static void persist( Signe s)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(s);
    }
    //recherche
	//par id
    public static Signe getSigneById( long id )
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        //Query q = em.createQuery("select s from Signe s where s.id = :id");
        //q.setParameter("id", id );
        //return (Signe) q.getSingleResult();
        return em.find(Signe.class,id);
    }
	//toutes les signes
	public List<Signe> getAllSigne() {
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery("SELECT a from Signe a");
        List<Signe> results = (List<Signe>) q.getResultList();
        return results;
    }
	
	
	
	
}
