/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import metier.modele.Prediction;

/**
 *
 * @author Administrateur
 */
public class PredictionDao {
        

    public static void persist( Prediction p)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(p);
    }
    
    public static Prediction getPredictionById( long id )
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        //Query q = em.createQuery("select p from Prediction p where p.id = :id");
        //q.setParameter("id", id );
        //return (Prediction) q.getSingleResult();
        return em.find(Prediction.class,id);
    }
}
