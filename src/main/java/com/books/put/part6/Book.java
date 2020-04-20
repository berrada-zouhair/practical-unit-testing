package com.books.put.part6;

public class Book {

  private String title;
  private Language language;
  private int pages;

  public Book(String title) {
    this.title = title;
  }

  public Book(Language language) {
    this.language = language;
  }

  public Book(String title, Language language, int pages) {
    this.title = title;
    this.language = language;
    this.pages = pages;
  }

  public String getTitle() {
    return title;
  }

  public Language getLanguage() {
    return language;
  }

  public int getPages() {
    return pages;
  }
}
