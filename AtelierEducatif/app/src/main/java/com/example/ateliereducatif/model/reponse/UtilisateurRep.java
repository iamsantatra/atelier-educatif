package com.example.ateliereducatif.model.reponse;

import com.example.ateliereducatif.model.Utilisateur;

public class UtilisateurRep {
    private String token;
    private String message;
    private Utilisateur data;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UtilisateurRep() {
    }

    public Utilisateur getUtilisateur() {
      return data;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
      this.data = utilisateur;
    }
}
