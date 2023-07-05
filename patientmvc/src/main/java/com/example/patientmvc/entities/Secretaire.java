package com.example.patientmvc.entities;

public class Secretaire  extends Utilisateur{
    private static Secretaire SECRETAIRE=new Secretaire();
    public static Secretaire getInstance()
    {return SECRETAIRE; }
    private Secretaire(){

        login="secretaire";
        motDePasse="adminsecretaire";
        role=Role.SECRETAIRE;

    }
}
