package com.books.put.part2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTestManyParams {

  @Test
  void constructor_should_set_amount() {
    Money money = new Money(100.1f, "USD");
    float amount  = money.getAmount();
    assertThat(amount).isEqualTo(100.1f);
  }

  @ParameterizedTest
  @ValueSource(floats = {100.5f, 20.7f, 50f, 11.2f})
  void constructor_should_set_amounts(float amount) {
    Money money = new Money(amount, "USD");
    float amountSet  = money.getAmount();
    assertThat(amountSet).isEqualTo(amount);
  }

  @ParameterizedTest
  @CsvSource({
      "100.5f, USD",
      "20.7f, EUR",
      "50f, DHS",
  })
  void constructor_should_set_amounts_and_currencies(float amount, String currency) {
    Money money = new Money(amount, currency);
    float amountSet  = money.getAmount();
    String currencySet = money.getCurrency();
    assertThat(amountSet).isEqualTo(amount);
    assertThat(currencySet).isEqualTo(currency);
  }


}