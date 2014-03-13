/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Administrateur
 */
@Entity
public class Amour {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
    
	@ManyToOne
    private Signe partenaire;   

	//constructeurs
    public Amour()
	{
		super();
    }

    public Amour(Signe partenaire)
   {
       super();
       this.partenaire = partenaire;
   }
   
   //affichage
	public String getType()
	{
		return "amour: ";
	}
    
}