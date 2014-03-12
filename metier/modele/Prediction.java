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
public abstract class Prediction {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
    public String contenu;
    public int niveau;
    @ManyToOne
    private Horoscope horoscope;
}
