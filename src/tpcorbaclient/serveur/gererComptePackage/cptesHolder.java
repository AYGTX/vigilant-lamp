package tpcorbaclient.serveur.gererComptePackage;


/**
* serveur/gererComptePackage/cptesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from serveur.idl
* Friday, December 4, 2020 3:30:59 PM WAT
*/

public final class cptesHolder implements org.omg.CORBA.portable.Streamable
{
  public tpcorbaclient.serveur.gererComptePackage.Compte value[] = null;

  public cptesHolder ()
  {
  }

  public cptesHolder (tpcorbaclient.serveur.gererComptePackage.Compte[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = tpcorbaclient.serveur.gererComptePackage.cptesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    tpcorbaclient.serveur.gererComptePackage.cptesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return tpcorbaclient.serveur.gererComptePackage.cptesHelper.type ();
  }

}