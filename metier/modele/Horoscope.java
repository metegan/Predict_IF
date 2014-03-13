/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Administrateur
 */
@Entity
public class Horoscope implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
	
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar datePrediction;
	
	
	@ManyToOne
    protected Sante sante;
    @ManyToOne
    protected Amour amour;
    @ManyToOne                  
    protected Client client;
       
	@ManyToOne
    private Medium medium;
    
	
	//getters 
	
	 public PredictionTravail getPredictionsTravail() {
        return travail;
    }
	
	public PredictionSante getPredictionsSante() {
        return sante;
    }
	
	public PredictionAmour getPredictionsAmour() {
        return amour;
    }
	public Calendar getDatePrediction() {
        return datePrediction;
    }

	public Client getClient() {
        if( client == null ) {
            throw new NullPointerException("Pas de clients avec ce horoscope");
        } else {
            return client;
        }
    }
	public Medium getMedium() {
        if( medium == null ) {
            throw new NullPointerException("Aucun medium attribué a cet horoscope)");
        } else {
            return medium;
        }
    }

	//setters 
	
    public void setPredictionsTravail( Travail travail ) {
        this.travail = travail;
    }

    

    public void setPredictionsSante(Sante sante) {
        this.sante = sante;
    }

   

    public void setPredictionsAmour(Amour amour) {
        this.amour = amour;
    }

    
    public void setDatePrediction(Calendar datePrediction) {
        this.datePrediction = datePrediction;
    }


    public void setClient(Client client) {
        this.client = client;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    @Override
    public String toString() {
        SimpleDateFormat d_format = new SimpleDateFormat("dd MMMM yyyy");
        String res = "";
        res += ((client.getPrenom() != null) ? client.getPrenom() : "") + " " + 
				((client.getNom()!= null) ? client.getNom() : "") + "\n" + 
                ((client.getAddress() != null) ? client.getAddress() : "")
                + "\n" + ((client.getTelephone() != null) ? client.getTelephone() :"") + "\nVotre numéro client : "
                + client.id + "\nVotre signe astologique : " + client.getSigne()
                + "\nListe des mediums du client" + client.getMediums().toString()
                + "\nLe " + d_format.format(datePrediction) + ", \n";
                + "\nMedium choisi : " + medium.getPseudo() + "\n";


        res += "\n" + amour.getTitle() + " " + predictionsAmour.getDescription() + "\n";
        res += travail.getTitle() + " " + predictionsTravail.getDescription() + "\n";
        res += sante.getTitle() + " " + predictionsSante.getDescription() + "\n";

        return res;
    }
    
    
    
}
