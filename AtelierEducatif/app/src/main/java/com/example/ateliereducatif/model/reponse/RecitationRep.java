package com.example.ateliereducatif.model.reponse;

import com.example.ateliereducatif.model.Recitation;

import java.util.List;

public class RecitationRep {
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<Recitation> getData() {
    return data;
  }

  public void setData(List<Recitation> data) {
    this.data = data;
  }

  private String message;
  private List<Recitation> data;

  public RecitationRep(String message, List<Recitation> data) {
    this.setMessage(message);
    this.setData(data);
  }

  public RecitationRep() {
  }

}
