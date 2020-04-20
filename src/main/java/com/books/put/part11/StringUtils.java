package com.books.put.part11;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StringUtils {

  public static String reverse(String string) {
    if (Objects.isNull(string)) {
      return null;
    }
    List<Character> listChars = new ArrayList<>(string.length());
    for (char c : string.toCharArray()) {
      listChars.add(c);
    }
    Collections.reverse(listChars);
    return listChars.stream()
        .map(Object::toString)
        .collect(joining(""));
  }
}
