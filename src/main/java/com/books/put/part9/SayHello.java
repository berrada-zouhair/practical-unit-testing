package com.books.put.part9;

public class SayHello {

  private TimeProvider timeProvider;

  public SayHello(TimeProvider timeProvider) {
    this.timeProvider = timeProvider;
  }

  public String sayHello() {
    if (timeProvider.getHourOfDay() < 12) {
      return "Good morning !";
    }
    return "Good after noon !";
  }
}
