package com.books.put.part11;

public class OperatingSystem {

  private int nbrOfBites;
  private int version;
  private int releaseYear;

  public OperatingSystem() {
    version = 9;
    nbrOfBites = 128;
    releaseYear = 2019;
  }

  public int getNbrOfBites() {
    return nbrOfBites;
  }

  public int getVersion() {
    return version;
  }

  public int getReleaseYear() {
    return releaseYear;
  }
}
