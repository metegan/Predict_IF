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
	//recherche de tous les clients 
	public List<Client> getAllClients() {
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery("SELECT c from Client c");
        List<Client> clients = (List<Client>) q.getResultList();
        return clients;
    }
	//client par employe
	public List<Client> getClientByEmploye(Employe e) { 
        int employeId = e.getId();
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery("SELECT e from Employe e WHERE =" + employeId);   
        List<Client> clients = (List<Client>) q.getResultList();
        return clients;
    }
	//client par nom
	public List<Client> getClientsByName(String name) {
        String query = "SELECT c FROM Client c WHERE";
        
        for(String n : name.split(" ")) {
            query += "'c.prenom' LIKE '%"+n+"%' OR 'c.nom' LIKE '%"+n+"%' OR ";
        }
        query = query.substring(0, query.length() - 3);
        
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery(query);
        List<Client> clients=(List<Client>) q.getResultList();
        return clients ;
	}
	
	
	
	
	
	
    
}
