package metier.modele;

import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
@Entity
public class Medium {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
	
    private String pseudo;
    
	//@ManyToMany
    //private Set<Client>  client;
    
	//@OneToMany
    //private List<Horoscope>  horoscope;
    
    //constructuers
    public Medium(String pseudo)
    {
        this.pseudo = pseudo;
    }
	
    public Medium()
    {
        this.pseudo = "-";
    }
    //getters
    public long  getId()
    {
        return this.id;
    }
    public String getPseudo()
    {
        return this.pseudo;
    }
	//setters
	
	public void setPseudo(String pseudo)
	{
        this.pseudo = pseudo;
    }
	//affichage
	public void toString()
	{
		return pseudo;
	}
	
            
}
