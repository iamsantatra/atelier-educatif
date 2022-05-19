package com.example.ateliereducatif.model;

public class Recitation {


  private String _id;
  private String lien;

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public String getLien() {
    return lien;
  }

  public void setLien(String lien) {
    this.lien = lien;
  }

  public Recitation(String _id, String lien) {
    this.set_id(_id);
    this.setLien(lien);
  }

}
