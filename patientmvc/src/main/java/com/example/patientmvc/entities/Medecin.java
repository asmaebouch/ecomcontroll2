package com.example.patientmvc.entities;

public class Medecin extends Utilisateur{
    private static Medecin MEDECIN = new Medecin();
    public static Medecin getInstance(){
        return MEDECIN;
    }
    private Medecin(){
        login="medecin";
        motDePasse="adminmedecin";
        role=Role.MEDECIN;

    }
}
