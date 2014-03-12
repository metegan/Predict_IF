/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import metier.modele.Employe;

/**
 *
 * @author Administrateur
 */
public class EmployeDao {
        
    public static void persist( Employe e)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(e);
    }
    
    public static Employe getEmployeById( long id )
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        //Query q = em.createQuery("select e from Employe e where e.id = :id");
        //q.setParameter("id", id );
        //return (Employe) q.getSingleResult();
        return em.find(Employe.class,id);
    }
}
