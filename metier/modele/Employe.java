/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.io.Serializable;
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
public class Employe implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
	
    private String nom;
    private String prenom;
   
    @OneToMany(mappedBy="employe")
    private  List<Client> clients;
    
	//constructeurs
    public Employe(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
    }
    public Employe()
    {
        this.nom = "-";
        this.prenom = "-";
    }
	//getters 
	
	public int getId() {
        return id;
    }
    public String getPrenom() {
        return prenom;
    }

    public String getNom(){
        return nom;
    }
	
	public List<Client> getClients()
	{
		return clients;
	}
	
	
	
	//setters
	
	public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
	
	//ajout d'un client
	
	public void AddClient ( Client c)
	{
		clients.add(c);
	}
	// affichage
	
	@Override
	public String toString() 
	{
        return prenom + " " + nom;
	}
    
}
