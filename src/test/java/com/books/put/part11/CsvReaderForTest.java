package com.books.put.part11;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CsvReaderForTest {

  @ParameterizedTest
  @CsvFileSource(resources = "/discount-data.csv", numLinesToSkip = 1)
  void should_check_discount_amount(double amount, double discount) {
    double calculateDiscount = DiscountCalculator.calculateDiscount(amount);
    Assertions.assertThat(calculateDiscount).isEqualTo(discount, Offset.offset(0.0001));
  }
}
