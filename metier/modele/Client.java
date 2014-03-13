/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import dao.EmployeDao;
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
    private List<Medium> mediums;
    
	@ManyToOne
    private Signe signe;
	
	@OneToMany 
	private List<Horoscope> horoscopes;
    
	@ManyToOne
    private Employe employe;
	
	enum CIVILITE { M, F, N;}
    
    private String nom;
	private String prenom;
    private String mail;
    private CIVILITE civilite;
    private boolean publicite;
    private String telephone;
    private String adresse;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dateNaissance;
	
	
	//constructeurs
    public Client() 
	{	
		this.nom = "-";
		this.prenom = "-";
		this.mail = "";
		this.civilite = CIVILITE.N;
		this.publicite = true;
		this.telephone = "";
		this.adresse = "";
        this.dateNaissance = Calendar.getInstance();
        this.dateNaissance.set(1920,01,01);
    }

    /**
     * 
     * @param nom 
     */
    public Client( String nom, String nom, String mail, boolean civilite, 
	boolean publicite, String telephone, String adresse, int jour, int mois, int annee )
    {
        this.nom = nom;
		this.prenom = prenom;
        this.mail = mail;
        if(civilite) this.civilite=CIVILITE.M;
			else this.civilite=CIVILITE.F;
        this.publicite = publicite;
        this.adresse = adresse;
        this.telephone = telephone;
        this.dateNaissance = Calendar.getInstance();
        this.dateNaissance.set(annee,mois,jour);
    }
    //setters
    public void setEmploye()
	{
		this.emp = new EmployeDao.getEmployeAvecLeMoinsDeClient();
	}
	
	 public void addMedium(Medium m)  
    {
        this.medium.add(m);
    }
	
	public void addMedium(Medium m) {
        this.mediums.add(m);
    }
    
    public void addHoroscope(Horoscope h) {
        this.horoscopes.add(h);
    }
	
	
	//getters 
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
	
	public Signe getSigne() {
        return signe;
    }

    public List<Medium> getMediums() {
        return mediums;
    }
	
	//affichage
	@Override
	public String toString()
	{
		String res;
		res = prenom + " " + nom + " " + 
		dateNaissance.toString() + " " + getMail() 
		+ " " + getTelephone() + " " + getAddress() + 
		"\n Liste de mediums favoris : ";
		for(Medium m : mediums) res += m.toString()+", ";
        res += "\n";
		return res;
	}
	
	
	
	
}
