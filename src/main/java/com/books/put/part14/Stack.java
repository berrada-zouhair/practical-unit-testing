package com.books.put.part14;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stack<T> {

  private List<T> list = new ArrayList<>();

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public int size() {
    return list.size();
  }

  public void push(T element) {
    list.add(element);
  }

  public Optional<T> peek() {
    return list.isEmpty() ? Optional.empty() : Optional.of(list.get(list.size()-1));
  }

  public T pop() {
    if (list.isEmpty()) {
      throw new IllegalStateException();
    }
    return list.remove(list.size()-1);
  }
}
