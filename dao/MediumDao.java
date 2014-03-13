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
    
	//persist
    public void persist( Medium m)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(m);
    }
    //recherche
	//par id
    public Medium getMediumById( long id )
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        //Query q = em.createQuery("select m from Medium m where m.id = :id");
        //q.setParameter("id", id );
        //return (Medium) q.getSingleResult();
        return em.find(Medium.class,id);
	//tout
	public List<Medium> getAllMediums() {
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery("SELECT m from Medium m");
        List<Medium> mediums = (List<Medium>) q.getResultList();
        return mediums;
    }
}
