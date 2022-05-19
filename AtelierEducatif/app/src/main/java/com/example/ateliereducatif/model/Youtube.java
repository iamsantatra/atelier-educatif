package com.example.ateliereducatif.model;

public class Youtube {
  private String title;
  private String thumbnail_url;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getThumbnail_url() {
    return thumbnail_url;
  }

  public void setThumbnail_url(String thumbnail_url) {
    this.thumbnail_url = thumbnail_url;
  }

  public Youtube(String title, String thumbnail_url) {
    this.setTitle(title);
    this.setThumbnail_url(thumbnail_url);
  }

  public Youtube() {
  }
}
