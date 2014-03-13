/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Administrateur
 */
@Entity
public class Sante extends Prediction implements Serializable  {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
    private String conseil;
	
	//constructeurs
    public Sante(String conseil)
   {
       super();
       this.conseil = conseil;
   }
   public Sante()
   {
		super();
   }
    //getters
    public String getConseil() {
        return conseil;
    }
	//affichage
	public String getType()
	{
		return "sante";
	}
   
}
