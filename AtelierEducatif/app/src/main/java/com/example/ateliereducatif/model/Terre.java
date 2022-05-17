package com.example.ateliereducatif.model;

public class Terre {

  private String _id;
  private String image;
  private String titre;
  private String description;

  private Terre() {
  }

  public Terre(String _id, String image, String titre, String description) {
    this.set_id(_id);
    this.setImage(image);
    this.setTitre(titre);
    this.setDescription(description);
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
