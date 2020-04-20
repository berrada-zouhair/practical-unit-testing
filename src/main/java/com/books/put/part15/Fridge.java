package com.books.put.part15;

import static java.lang.String.format;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Fridge {

  private Set<String> items = new HashSet<>();

  public boolean put(String item) {
    return items.add(item);
  }

  public boolean contains(String item) {
    return items.contains(item);
  }

  public void take(String item) {
    if (!items.remove(item)) {
      throw new NoSuchElementException(format("fridge doesn't contain %s", item));
    }
  }
}
