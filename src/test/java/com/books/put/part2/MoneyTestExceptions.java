package com.books.put.part2;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTestExceptions {

  @ParameterizedTest
  @ValueSource(floats = {-1f, -200.2f, -11.3f})
  void constructor_should_throw_IAE_when_amount_less_than_zero(float invalidAmount) {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new Money(invalidAmount, "USD"));
  }
}
