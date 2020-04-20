package com.books.put.part11;

public class DiscountCalculator {

  public static double calculateDiscount(double amount) {
    if (amount < 1000) {
      return 0;
    } else if (amount>=1000 && amount < 2000) {
      return 0.01;
    } else if (amount>=2000 && amount < 5000) {
      return 0.02;
    } else {
      return 0.03;
    }
  }
}
