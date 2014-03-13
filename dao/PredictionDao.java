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
        
	//persist
    public static void persist( Prediction p)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(p);
    }
	
    //recherche
	//par id
	
    public static Prediction getPredictionById( long id )
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        //Query q = em.createQuery("select p from Prediction p where p.id = :id");
        //q.setParameter("id", id );
        //return (Prediction) q.getSingleResult();
        return em.find(Prediction.class,id);
    }
	//toutes les predictions 
	public List<Prediction> getAllPrediction() {
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery("SELECT p from Prediction p");
        List<Prediction> predictions = (List<Prediction>) q.getResultList();
        return predictions;
    }
	//par type de predictions
	/**
     * Returne toutes les prediction du type passe en parametre 
     * @param type type de prediction
     * @return 
     */
    public List<Prediction> getPredictionByType(int type) {
        String table = "";
        switch (type) {
            case Service.AMOUR:
                table = "Amour";
                break;
            case Service.SANTE:
                table = "Sante";
                break;
            case Service.TRAVAIL:
                table = "Travail";
        }

        String requete = "SELECT p FROM " + table + " p";
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery(requete);
        List<Prediction> predictions = (List<Prediction>) q.getResultList();
        return predictions;
    }
	
	//par type de predictions
	/**
     * Returne toutes les prediction du type passe en parametre et du niveau demande
     * @param type type de prediction
	 * @param niveau niveau de positivite de la prediction.
     * @return 
     */
    public List<Prediction> getPredictionByLevelAndType(int type, int niveau) {
        String table = "";
        switch (type) {
            case Service.AMOUR:
                table = "Amour";
                break;
            case Service.SANTE:
                table = "Sante";
                break;
            case Service.TRAVAIL:
                table = "Travail";
        }

        String query = "SELECT p FROM " + table + " p";
        if(positivite > 0) {
            query + = " WHERE p.niveau = " + niveau;
        }
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery(query);
        List<Prediction> predictions = (List<Prediction>) q.getResultList();
        return predictions;
    }
	//par mot
	public List<Prediction> getPredictionByWord(String mot) {

        String query_s = "SELECT p FROM Horoscope p";
        if (keywords.length() > 0) { 
		//si le parametre n'est pas un chaine vide
            query += " WHERE ";
        }
        for (String s : keywords.split(" ")) {
            query += " p.contenu LIKE \"%" + s.toLowerCase() + "\"% OR";
        }
        EntityManager em = JPAUtils.obtenirEntityManager();
        Query q = em.createQuery(query);
        List<Prediction> predictions = (List<Prediction>) q.getResultList();
        return predictions;
    }
    
	
	
	
	
}
