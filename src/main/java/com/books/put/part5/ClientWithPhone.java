package com.books.put.part5;

import java.util.Collection;
import java.util.HashSet;

public class ClientWithPhone {

  private Collection<Phone> phones = new HashSet<>();

  public void addPhone(Phone phone) {
    phones.add(phone);
  }

  public boolean hasMobile() {
    return phones.stream().anyMatch(phone -> phone.isMobile());
  }
}
