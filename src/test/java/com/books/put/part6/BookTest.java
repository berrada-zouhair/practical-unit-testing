package com.books.put.part6;

import static com.books.put.part6.Language.ENGLISH;
import static com.books.put.part6.Language.FRENCH;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.assertj.core.condition.AnyOf;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BookTest {

  private Condition<Book> writtenInEnglish = new Condition<Book>() {
    @Override
    public boolean matches(Book book) {
      return book.getLanguage().equals(ENGLISH);
    }
  };

  private Condition<Book> writtenInFrench = new Condition<Book>() {
    @Override
    public boolean matches(Book book) {
      return book.getLanguage().equals(FRENCH);
    }
  };

  private Condition<Book> moreThanOneHundredPages = new Condition<Book>() {
    @Override
    public boolean matches(Book book) {
      return book.getPages() > 100;
    }
  };

  private Condition<Book> moreThanTwoHundredsPages = new Condition<Book>() {
    @Override
    public boolean matches(Book book) {
      return book.getPages() > 200;
    }
  };

  @ParameterizedTest
  @ValueSource(strings = {"title1", "title2", "title3"})
  void constructor_should_set_title(String title) {
    Book book = new Book(title);
    BookAssert.assertThat(book).hasTitle(title);
  }

  @Test
  void should_book_be_written_in_english() {
    Book book = new Book(ENGLISH);
    Assertions.assertThat(book)
        .is(writtenInEnglish)
        .isNot(writtenInFrench);
  }

  @Test
  void should_book_be_written_in_french() {
    Book book = new Book(FRENCH);
    BookAssert.assertThat(book)
        .isWrittenIn(FRENCH)
        .isNot(writtenInEnglish);
  }

  @Test
  void should_book_be_written_in_english_and_have_more_100_page() {
    Book book = new Book("My title", ENGLISH, 170);
    BookAssert.assertThat(book)
        .hasTitle("My title")
        .isWrittenIn(ENGLISH)
        .isNot(writtenInFrench)
        .has(moreThanOneHundredPages)
        .doesNotHave(moreThanTwoHundredsPages);
  }

  @Test
  void should_book_be_written_in_english_or_have_more_100_page() {
    Book book = new Book("My title", ENGLISH, 170);
    BookAssert.assertThat(book)
        .hasTitle("My title")
        .is(AnyOf.anyOf(writtenInEnglish, writtenInFrench))
        .has(AnyOf.anyOf(moreThanOneHundredPages, moreThanTwoHundredsPages));
  }
}
