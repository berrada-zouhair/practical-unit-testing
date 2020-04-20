package com.books.put.part12;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//@RunWith(JUnitQuickcheck.class)
public class DiscountCalculatorTest {

  private DiscountCalculator discountCalculator = new DiscountCalculator();

  @ParameterizedTest
  @ValueSource(floats = {100, 200, 150, 999, 1000})
  void discount_between_100_and_1000_should_be_1(float amount) {
    int discount = discountCalculator.computeDiscount(amount);
    assertThat(discount).isEqualTo(1);
  }

  @ParameterizedTest
  @ValueSource(floats = {1001, 2000, 1500, 4999, 5000})
  void discount_between_1001_and_5000_should_be_2(float amount) {
    int discount = discountCalculator.computeDiscount(amount);
    assertThat(discount).as("applied discount").isEqualTo(2);
  }

  @Test
  void amount_as_0_should_throw_IAE() {
    Assertions.assertThatIllegalArgumentException()
        .isThrownBy(() -> discountCalculator.computeDiscount(0))
        .as("thrown exception for nul value")
        .withMessage("amount should not be nul");
  }

//  @Property(trials = 10)
//  public void negative_amount_should_throw_IAE(Float amount) {
//    Assume.assumeThat(amount, Matchers.greaterThan(0f));
//    Assertions.assertThatIllegalArgumentException()
//        .isThrownBy(() -> discountCalculator.computeDiscount(amount))
//        .withMessage("amount should be positive");
//  }
}
