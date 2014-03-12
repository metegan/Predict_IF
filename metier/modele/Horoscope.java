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
    private Calendar datePred;
    @OneToMany(mappedBy="horoscope")
    private List<Prediction> prediction;
    @ManyToOne
    private Medium medium;
    
    
    
    
}
