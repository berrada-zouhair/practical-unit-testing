package com.books.put.part6;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class BookAssert extends AbstractAssert<BookAssert, Book> {

  public BookAssert(Book book) {
    super(book, BookAssert.class);
  }

  public static BookAssert assertThat(Book book) {
    return new BookAssert(book);
  }

  public BookAssert hasTitle(String title) {
    isNotNull();
    Assertions.assertThat(this.actual.getTitle()).isEqualTo(title);
    return this;
  }

  public BookAssert isWrittenIn(Language language) {
    isNotNull();
    Assertions.assertThat(actual.getLanguage()).isEqualTo(language);
    return this;
  }
}
