/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author Administrateur
 */
@Entity
public class Signe {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
    private String leSigne;
    private String[] nomSigne= { "CAPRICORNE", "VERSEAU", "POISSON", "BELIER", "TAUREAU" , "GEMEAUX", "CANCER",  "LION", "VIERGE",   "BALANCE" ,  "SCORPION", "SAGITTAIRE"};
    @OneToMany
    private List<Client> client;
    @OneToMany
    private List<Amour> amour;   
    
    public Signe()
    {
        
    }
    public void setSigne(int mois)
    {
        this.leSigne = nomSigne[mois-1];
    }
            
}
