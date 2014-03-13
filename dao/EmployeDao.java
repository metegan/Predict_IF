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
	
	//tous les employes 
	public List<Employe> getAllEmploye() {
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery("SELECT e from Employe e");
        List<Employe>  employes  = (List<Employe>) q.getResultList();
        return employes;
    }
	
	
	//employe avec le moins de clients
	
	public Employe getEmployeMoinsDeClients() {
        EntityManager em = JPAUtils.obtenirEntityManager();
        try
		{
        Query q = em.createQuery("SELECT e from Employe e ORDER BY size(e.clients)");
        Employe em = (Employe) q.getResultList().get(0); //le premier dans la liste
		
        return em;
        }
		
		catch(IndexOutOfBoundsException i)
		{
			return null;
        } 
    }
	
	
	
}
