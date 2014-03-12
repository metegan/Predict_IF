/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.ArrayList;
import java.util.List;
import metier.modele.Client;
import metier.modele.Medium;
import metier.service.Service;

/**
 *
 * @author Administrateur
 */
public class main {
    public static void main(String[] args) {
        Client c;
        Medium m;
        Service s = new Service();
        List<Medium> meds = new ArrayList();
        c = new Client( "martin", "martin@car.com",true, false, "0666778899", "Lyon", 5, 11, 2012 );
        m = new Medium("tarte");
        meds.add(m);
        for( Medium med:meds ) {
            s.addMedium(med);
        }
        Service.addClient(c);
        s.MediumToClient(c, meds);
        //Service.addMediumToClient(m, c);
        Client d = Service.getClient(2);
        System.out.println(d.getNom());
        System.out.println(d.getDateNaissance());
        
    }
}
