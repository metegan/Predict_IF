/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Prediction {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
	
    protected String contenu;
    protected int niveau;
	protected char symblol;
	
	//setters
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }
	//getters
    public int getNiveau() {
        return niveau;
    }

    public String getContenu() {
        return contenu;
    }

    public char getSymbole() {
        return symbole;
    }
    
    
  
}
