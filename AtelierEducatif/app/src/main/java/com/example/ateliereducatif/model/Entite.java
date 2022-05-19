package com.example.ateliereducatif.model;

public class Entite {

  private String id;
  private String nom;
  private String image;
  private String type;
  private String cri;

  public String getCri() {
    return cri;
  }

  public void setCri(String cri) {
    this.cri = cri;
  }

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

  public Entite(String nom, String image) {
    this.setNom(nom);
    this.setImage(image);
  }

  public Entite(String id, String nom, String image, String type, String cri) {
    this.setId(id);
    this.setNom(nom);
    this.setImage(image);
    this.setType(type);
    this.setCri(cri);
  }
}
