/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servant;

import tpcorba.serveur.gererComptePOA;
import tpcorba.serveur.gererComptePackage.Compte;

/**
 *
 * @author AYGTX
 */
public class GererCompteImpl extends gererComptePOA {

    @Override
    public Compte getCompte(int code) {
        return new Compte(code, Math.random() * 10000);
    }
    
}
