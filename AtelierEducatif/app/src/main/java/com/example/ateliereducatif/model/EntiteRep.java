package com.example.ateliereducatif.model;

import java.util.List;

public class EntiteRep {
  private String message;
  private List<Entite> data;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<Entite> getData() {
    return data;
  }

  public void setData(List<Entite> data) {
    this.data = data;
  }

  public EntiteRep() {
  }

  public EntiteRep(String message, List<Entite> data) {
    this.message = message;
    this.data = data;
  }
}
