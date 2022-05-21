package com.example.ateliereducatif.model.reponse;

import com.example.ateliereducatif.model.Terre;

import java.util.List;

public class TerreRep {

  private List<Terre> terres;
  private int totalPages;

  public TerreRep( List<Terre> terres, int totalPages) {
    this.setTerres(terres);
    this.setTotalPages(totalPages);
  }

  public TerreRep() {
  }

  public List<Terre> getTerres() {
    return terres;
  }

  public void setTerres(List<Terre> terres) {
    this.terres = terres;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }
}
