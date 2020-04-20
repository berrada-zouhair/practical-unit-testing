package com.books.put.part15;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FridgeTest {

  private Fridge fridge;
  private String CHEESE_ITEM;

  @BeforeEach
  void setUp() {
    fridge = new Fridge();
    CHEESE_ITEM = "cheese";
  }

  @Test
  void should_put_an_item_in_fridge() {
    assertThat(fridge.put(CHEESE_ITEM)).isTrue();
    assertThat(fridge.contains(CHEESE_ITEM)).isTrue();
  }

  @Test
  void fridge_should_not_contain_non_put_item() {
    assertThat(fridge.contains(CHEESE_ITEM)).isFalse();
  }

  @Test
  void taking_put_item_from_fridge_should_not_throw_any_exception() {
    fridge.put(CHEESE_ITEM);
    assertThatCode(() -> fridge.take(CHEESE_ITEM)).doesNotThrowAnyException();
  }

  @Test
  void taking_put_item_should_remove_it_from_fridge() {
    fridge.put(CHEESE_ITEM);
    fridge.take(CHEESE_ITEM);
    assertThat(fridge.contains(CHEESE_ITEM)).isFalse();
  }

  @Test
  void should_throw_NSEE_when_taking_non_put_element_from_fridge() {
    assertThatExceptionOfType(NoSuchElementException.class)
        .isThrownBy(() -> fridge.take(CHEESE_ITEM))
        .withMessage("fridge doesn't contain %s", CHEESE_ITEM);
  }
}
