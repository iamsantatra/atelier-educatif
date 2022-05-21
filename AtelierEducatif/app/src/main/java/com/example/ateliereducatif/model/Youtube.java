package com.example.ateliereducatif.model;

import android.widget.TextView;
import android.widget.Toast;

import com.example.ateliereducatif.R;
import com.example.ateliereducatif.adapter.EntiteAdapter;
import com.example.ateliereducatif.controller.ListeAnimauxActivity;
import com.example.ateliereducatif.model.reponse.EntiteRep;
import com.example.ateliereducatif.model.reponse.YoutubeRep;
import com.example.ateliereducatif.service.RecitationService;
import com.example.ateliereducatif.utils.RetrofitClient;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Youtube implements Serializable {

  private String title;
  private String author_name;
  private String author_url;
  private String type;
  private float height;
  private float width;
  private String version;
  private String provider_name;
  private String provider_url;
  private float thumbnail_height;
  private float thumbnail_width;
  private String thumbnail_url;
  private String html;
  private String lien;
  private List<Youtube> yListe;

  // Getter Methods

  public String getTitle() {
    return title;
  }

  public String getAuthor_name() {
    return author_name;
  }

  public String getAuthor_url() {
    return author_url;
  }

  public String getType() {
    return type;
  }

  public float getHeight() {
    return height;
  }

  public float getWidth() {
    return width;
  }

  public String getVersion() {
    return version;
  }

  public String getProvider_name() {
    return provider_name;
  }

  public String getProvider_url() {
    return provider_url;
  }

  public float getThumbnail_height() {
    return thumbnail_height;
  }

  public float getThumbnail_width() {
    return thumbnail_width;
  }

  public String getThumbnail_url() {
    return thumbnail_url;
  }

  public String getHtml() {
    return html;
  }

  // Setter Methods

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor_name(String author_name) {
    this.author_name = author_name;
  }

  public void setAuthor_url(String author_url) {
    this.author_url = author_url;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public void setWidth(float width) {
    this.width = width;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public void setProvider_name(String provider_name) {
    this.provider_name = provider_name;
  }

  public void setProvider_url(String provider_url) {
    this.provider_url = provider_url;
  }

  public void setThumbnail_height(float thumbnail_height) {
    this.thumbnail_height = thumbnail_height;
  }

  public String getLien() {
    return lien;
  }

  public void setLien(String lien) {
    this.lien = lien;
  }

  public void setThumbnail_width(float thumbnail_width) {
    this.thumbnail_width = thumbnail_width;
  }

  public void setThumbnail_url(String thumbnail_url) {
    this.thumbnail_url = thumbnail_url;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  public Youtube(String title, String thumbnail_url) {
    this.setTitle(title);
    this.setThumbnail_url(thumbnail_url);
  }

  public Youtube() {
  }
}
