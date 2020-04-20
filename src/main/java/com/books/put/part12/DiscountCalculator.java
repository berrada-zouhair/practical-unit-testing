package com.books.put.part12;

public class DiscountCalculator {

  public int computeDiscount(float amount) {
    if (amount == 0) {
      throw new IllegalArgumentException("amount should not be nul");
    }
    if (amount == -1) {
      throw new IllegalArgumentException("amount should be positive");
    }
    if(amount >= 1001f) {
      return 2;
    }
    return 1;
  }
}
