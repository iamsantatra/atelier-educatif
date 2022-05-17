package com.example.ateliereducatif.model.reponse;

import com.example.ateliereducatif.model.Terre;

import java.util.List;

public class TerreRep {

  private int totalItems;
  private List<Terre> terres;
  private int totalPages;
  private int currentPage;
  private boolean hasNextPage;
  private boolean hasPrevPage;
  private Integer nextPage;
  private Integer prevPage;

  public TerreRep(int totalItems, List<Terre> terres, int totalPages, int currentPage, boolean hasNextPage, boolean hasPrevPage, Integer nextPage, Integer prevPage) {
    this.setTotalItems(totalItems);
    this.setTerres(terres);
    this.setTotalPages(totalPages);
    this.setCurrentPage(currentPage);
    this.setHasNextPage(hasNextPage);
    this.setHasPrevPage(hasPrevPage);
    this.setNextPage(nextPage);
    this.setPrevPage(prevPage);
  }

  public TerreRep() {
  }

  public int getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(int totalItems) {
    this.totalItems = totalItems;
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

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public boolean isHasNextPage() {
    return hasNextPage;
  }

  public void setHasNextPage(boolean hasNextPage) {
    this.hasNextPage = hasNextPage;
  }

  public boolean isHasPrevPage() {
    return hasPrevPage;
  }

  public void setHasPrevPage(boolean hasPrevPage) {
    this.hasPrevPage = hasPrevPage;
  }

  public Integer getNextPage() {
    return nextPage;
  }

  public void setNextPage(Integer nextPage) {
    this.nextPage = nextPage;
  }

  public Integer getPrevPage() {
    return prevPage;
  }

  public void setPrevPage(Integer prevPage) {
    this.prevPage = prevPage;
  }
}
