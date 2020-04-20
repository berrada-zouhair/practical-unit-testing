package com.books.put.part11;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringUtilsTest {

  @ParameterizedTest
  @CsvSource({"zouHair, riaHuoz", "Zakaria, airakaZ", "paris, sirap", "casa, asac"})
  void should_reverse_all_strings(String string, String reversedString) {
    assertThat(StringUtils.reverse(string)).isEqualTo(reversedString);
  }

  @Test
  void should_not_throw_NPE_when_string_is_null() {
    assertThatCode(
        () -> StringUtils.reverse(null))
        .doesNotThrowAnyException();
  }

  @Test
  void should_return_null_when_null() {
    assertThat(StringUtils.reverse(null)).isNull();
  }


  @Test
  void should_return_empty_string_when_empty() {
    assertThat(StringUtils.reverse("")).isEmpty();
  }

  @Test
  void should_return_same_string_when_it_has_one_char() {
    assertThat(StringUtils.reverse("a")).isEqualTo("a");
  }
}
