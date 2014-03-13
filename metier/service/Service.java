/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.ClientDao;
import dao.EmployeDao;
import dao.HoroscopeDao;
import dao.JpaUtil;
import dao.MediumDao;
import dao.PredictionDao;
import java.util.List;
import metier.modele.Client;
import metier.modele.Employe;
import metier.modele.Horoscope;
import metier.modele.Medium;
import metier.modele.Prediction;

/**
 *
 * @author Administrateur
 */
public class Service {
                  
    public Service() {
	public static final int TRAVAIL = 0;
    public static final int SANTE = 1;
    public static final int AMOUR = 2;
   
	//ajout de client, medium, prediction, horoscope, employe
    public static void addClient( Client c )
    {
		  try {

            JPAUtils.creerEntityManager();
            JPAUtils.ouvrirTransaction();
            new ClientDao.persist(c);
            JPAUtils.validerTransaction();
            JPAUtils.fermerEntityManager();
        } 
		catch (RollbackException ex) {
            JPAUtils.annulerTransaction();
        }
    }

    public void addMedium( Medium m )
    {
           try {
            JPAUtils.creerEntityManager();
            JPAUtils.ouvrirTransaction();
            new MediumDao().persist(m);
            JPAUtils.validerTransaction();
            JPAUtils.fermerEntityManager();
        } 
		catch (RollbackException ex) {
            JPAUtils.annulerTransaction();
        }
    }
   
    public static void addPrediction( Prediction p )
    {
        try {
            JPAUtils.creerEntityManager();
            JPAUtils.ouvrirTransaction();
            new PredictionDao().persist(p);
            JPAUtils.validerTransaction();
            JPAUtils.fermerEntityManager();
        } 
		catch (RollbackException ex) {
            JPAUtils.annulerTransaction();
        }
    }
 
   public static void addHoroscope( Horoscope h )
    {
        try {
            JPAUtils.creerEntityManager();
            JPAUtils.ouvrirTransaction();
            new HoroscopeDao().insert(h);
            JPAUtils.validerTransaction();
            JPAUtils.fermerEntityManager();
        } 
		catch (RollbackException ex) {
            JPAUtils.annulerTransaction();
        }
    }
      
   
    public static void addEmploye( Employe em )
    {
         try {
            JPAUtils.creerEntityManager();
            JPAUtils.ouvrirTransaction();
            new EmployeDao().insert(em);
            JPAUtils.validerTransaction();
            JPAUtils.fermerEntityManager();
        } 
		catch (RollbackException ex) {
            JPAUtils.annulerTransaction();
        }
    }
      
	//getters 
	//liste des clients 
	public static List<Client> getClients()
    {
       

        JPAUtils.creerEntityManager();
        List<Client> clients = new ClientDao().getAllClients();
		JPAUtils.fermerEntityManager();
        return clients;
            
    }
	//liste de mediums
    public static List<Medium> getMediums()
    {
        JPAUtils.creerEntityManager();
        List<Medium> mediums = new MediumDao().getAllMediums();
        JPAUtils.fermerEntityManager();
        return mediums;
    }
	
	
	//ajout d un medium a un client 
    public void addMediumToClient( Medium m, Client c)
    {
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        Client c1 = getClient(c.getId());
        Medium m1 = getMedium(m.getId());
        c1.addMedium(m1);
        ClientDao.persist(c1);
        ClientDao.merge(m1);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
    }
    //
    public void MediumToClient( Client c, List<Medium> mediums )
    {
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        Medium c_med;
        c = ClientDao.getClient(c.getId());
        for( int i=0; i<mediums.size(); i++ )
        {
            c_med = mediumDao.getMedium(mediums.get(i).getId());
            c.addMedium(c_med);
        }
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
    }
	// affichage
	public static String afficherListeClients() {
        JPAUtils.creerEntityManager();
        List<Client> clients = new ClientDao().getAllClients();
        JPAUtils.fermerEntityManager();
        return clients.toString();
    }
	//liste historique des predictions d un client
	public static List<Horoscope> generateOldPredictions(Client c) {
        JPAUtils.creerEntityManager();
        List<Horoscope> horoscopes =
		new HoroscopeDao().getHoroscopesByClient(c);
        JPAUtils.fermerEntityManager();
        return horoscopes;
    }
	//liste predictions par type et niveau 
	public static List<Prediction> generateListePredictions(int type, int niveau) {
        JPAUtils.creerEntityManager();
        List<Prediction> predictions = new PredictionDao()
                .getPredictionByLevelAndType(type, niveau);
        JPAUtils.fermerEntityManager();
        return predictions;
    }
    //l employe qui a le moins de clients 
    public static Employe generateEmployeMoinsDeClients() { 
        JPAUtils.creerEntityManager();
        Employe e = new EmployeDao().getEmployeMoinsDeClients();
        JPAUtils.fermerEntityManager();
        return e;
    }
    
	
	

	
	
	
	
    
}
