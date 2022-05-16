package com.example.ateliereducatif.model;

public class Entite {

  private String id;
  private String nom;
  private String image;
  private String type;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Entite() {
  }

  public Entite(String id, String nom, String image, String type) {
    this.id = id;
    this.nom = nom;
    this.image = image;
    this.type = type;
  }
}
