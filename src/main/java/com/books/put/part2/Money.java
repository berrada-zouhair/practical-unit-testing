package com.books.put.part2;


import lombok.Getter;

@Getter
public class Money {

  private final float amount;
  private final String currency;

  public Money(float amount, String currency) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
    this.amount = amount;
    this.currency = currency;
  }
}
