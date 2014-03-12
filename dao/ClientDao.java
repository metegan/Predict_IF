/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Client;
import metier.modele.Medium;


/**
 *
 * @author Administrateur
 */
public class ClientDao {

    public static void persist( Client c)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(c);
    }
    
    public static void merge( Medium m)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.merge(m);
    }
    
    public static Client getClient( long id )
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("select c from Client c where c.id = :id");
        q.setParameter("id", id );
        return (Client) q.getSingleResult();
    }

    
}
