/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Medium;

/**
 *
 * @author Administrateur
 */
public class MediumDao {
    

    public void persist( Medium m)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(m);
    }
    
    public Medium getMediumById( long id )
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        //Query q = em.createQuery("select m from Medium m where m.id = :id");
        //q.setParameter("id", id );
        //return (Medium) q.getSingleResult();
        return em.find(Medium.class,id);
    }
}
