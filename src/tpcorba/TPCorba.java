/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcorba;

import com.sun.corba.se.impl.oa.poa.POAImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import servant.GererCompteImpl;
import tpcorba.serveur.gererCompte;
import tpcorba.serveur.gererCompteHelper;

/**
 *
 * @author AYGTX
 */
public class TPCorba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            ORB orb = ORB.init(args, null);
            
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            
            rootPOA.the_POAManager().activate();
            
            GererCompteImpl gci = new GererCompteImpl();
            
            org.omg.CORBA.Object refGCI =  rootPOA.servant_to_reference(gci);
            
            gererCompte gc = gererCompteHelper.narrow(refGCI);
            
            org.omg.CORBA.Object objetRef = orb.resolve_initial_references("NameService");
            
            NamingContextExt nom = NamingContextExtHelper.narrow(objetRef);
            
            NameComponent root[] = nom.to_name("Gestion");
            
            nom.rebind(root, gc);
            
            System.out.println("Serveur Démarré");
            for (;;) {orb.run();}
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
