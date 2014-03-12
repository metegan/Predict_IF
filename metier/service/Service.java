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
    MediumDao mediumDao;
               
    public Service() {
        mediumDao = new MediumDao();
    }

    /**************************************************************************
     *                      ADD
     * /***********************************************************************/
    public static void addClient( Client c )
    {
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        ClientDao.persist(c);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
    }

    public void addMedium( Medium m)
    {
            JpaUtil.creerEntityManager();
            try {
                JpaUtil.ouvrirTransaction();
                mediumDao.persist(m);
                JpaUtil.validerTransaction();
            }
            catch( Exception e) {
                e.printStackTrace();
                JpaUtil.annulerTransaction();
            }
            finally {
                JpaUtil.fermerEntityManager();
            }
    }
   
        public static void addPrediction( Prediction p)
    {
        try {
            JpaUtil.creerEntityManager();
            try {
                JpaUtil.ouvrirTransaction();
                PredictionDao.persist(p);
                JpaUtil.validerTransaction();
            }
            catch( Exception e) {
                e.printStackTrace();
                JpaUtil.annulerTransaction();
            }
            finally {
                JpaUtil.fermerEntityManager();
            }
        }
        catch( Exception e) {
                e.printStackTrace();
        }
    }
 
   public static void addHoroscope( Horoscope h)
    {
        try {
            JpaUtil.creerEntityManager();
            try {
                JpaUtil.ouvrirTransaction();
                HoroscopeDao.persist(h);
                JpaUtil.validerTransaction();
            }
            catch( Exception e) {
                e.printStackTrace();
                JpaUtil.annulerTransaction();
            }
            finally {
                JpaUtil.fermerEntityManager();
            }
        }
        catch( Exception e) {
                e.printStackTrace();
        }
    }
      
   
      public static void addEmploye( Employe em)
    {
        try {
            JpaUtil.creerEntityManager();
            try {
                JpaUtil.ouvrirTransaction();
                EmployeDao.persist(em);
                JpaUtil.validerTransaction();
            }
            catch( Exception e) {
                e.printStackTrace();
                JpaUtil.annulerTransaction();
            }
            finally {
                JpaUtil.fermerEntityManager();
            }
        }
        catch( Exception e) {
        }
    }
      
    public static Client getClient( long id )
    {
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        Client c = ClientDao.getClient(id);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        return c;
    }
    public Medium getMedium( long id )
    {
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        Medium m = mediumDao.getMedium(id);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        return m;
    }
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
    
}
