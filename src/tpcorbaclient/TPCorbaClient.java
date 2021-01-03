/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcorbaclient;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import tpcorbaclient.serveur.gererCompte;
import tpcorbaclient.serveur.gererCompteHelper;
import tpcorbaclient.serveur.gererComptePackage.Compte;

/**
 *
 * @author AYGTX
 */
public class TPCorbaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //idlj -fall file.idl
        try {
            // TODO code application logic here
            ORB orb = ORB.init(args, null);
            
            org.omg.CORBA.Object objetRef = orb.resolve_initial_references("NameService");
            
            NamingContextExt nom = NamingContextExtHelper.narrow(objetRef);
            
            gererCompte stub = gererCompteHelper.narrow(nom.resolve_str("Gestion"));
            Compte compte = stub.getCompte(123);
            System.out.println("solde: " +compte.solde + " Code: "+  compte.code);
            
        } catch (Exception e) {
            //Logger.getLogger(TPCorba.class.getName()).log(Level.SEVERE, null, ex);
            e.printStackTrace();
        }
        
    }
    
}
