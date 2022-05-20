package com.example.ateliereducatif.model.reponse;

import com.example.ateliereducatif.model.Youtube;

import java.util.List;

public class YoutubeRep {
  private String message;
  private List<Youtube> data;

  public YoutubeRep(String message, List<Youtube> data) {
    this.setMessage(message);
    this.setData(data);
  }

  public YoutubeRep() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<Youtube> getData() {
    return data;
  }

  public void setData(List<Youtube> data) {
    this.data = data;
  }
}
