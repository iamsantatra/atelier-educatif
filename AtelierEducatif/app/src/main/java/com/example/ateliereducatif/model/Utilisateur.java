package com.example.ateliereducatif.model;

public class Utilisateur {

    private String _id;
    private String nom;
    private String nomUtilisateur;
    private String motDePasse;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Utilisateur(String _id, String nom, String nomUtilisateur, String motDePasse) {
        this.set_id(_id);
        this.setNom(nom);
        this.setNomUtilisateur(nomUtilisateur);
        this.setMotDePasse(motDePasse);
    }
}
