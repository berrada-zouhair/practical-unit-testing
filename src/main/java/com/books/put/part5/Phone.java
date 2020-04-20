package com.books.put.part5;

public class Phone {

  private final String phoneNumber;
  private final boolean mobile;

  public Phone(String phoneNumber, boolean mobile) {
    this.phoneNumber = phoneNumber;
    this.mobile = mobile;
  }

  public boolean isMobile() {
    return mobile;
  }
}
