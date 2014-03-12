/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;


import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Administrateur
 */
@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
    @ManyToMany
    private List<Medium> medium;
    @ManyToOne
    private Signe signe;
    @ManyToOne
    private Employe employe;
    
    private String nom = "";
    private String mail = "";
    private boolean civilite;
    private boolean publicite;
    private String telephone;
    private String adresse;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dateNaissance;

    public Client() {
    }

    /**
     * 
     * @param nom 
     */
    public Client( String nom, String mail, boolean civilite, boolean publicite, String telephone, String adresse, int jour, int mois, int annee )
    {
        this.nom = nom;
        this.mail = mail;
        this.civilite = civilite;
        this.publicite = publicite;
        this.adresse = adresse;
        this.telephone = telephone;
        this.dateNaissance = Calendar.getInstance();
        this.dateNaissance.set(annee,mois,jour);
    }
    
    
    public String getNom()
    {
        return this.nom;
    }
    public long  getId()
    {
        return this.id;
    }
    public String getDateNaissance()
    {
        return this.dateNaissance.toString();
    }
    public boolean addMedium(Medium m)  
    {
        return this.medium.add(m);
    }
}
