package com.books.put.part9;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class SayHelloTest {

  private TimeProvider timeProvider;
  private SayHello sayHello;

  private static int[] morningHours() {
    return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
  }

  private static Stream<Arguments> dataProvider() {
    return Stream.of(
        Arguments.of("Zouhair", 29, 92800),
        Arguments.of("Zakaria", 31, 20500)
    );
  }

  @BeforeEach
  void setUp() {
    timeProvider = mock(TimeProvider.class);
    sayHello = new SayHello(timeProvider);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
  void should_say_good_morning_when_morning(int hourOfDay) {
    when(timeProvider.getHourOfDay()).thenReturn(hourOfDay);
    String hello = sayHello.sayHello();
    assertThat(hello).isEqualTo("Good morning !");
  }

  @ParameterizedTest
  @MethodSource("morningHours")
  void should_say_good_morning_when_morning_hours(int hourOfDay) {
    when(timeProvider.getHourOfDay()).thenReturn(hourOfDay);
    String hello = sayHello.sayHello();
    assertThat(hello).isEqualTo("Good morning !");
  }

  @ParameterizedTest
  @ValueSource(ints = {12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23})
  void should_say_good_after_noon_when_after_noon(int hourOfDay) {
    when(timeProvider.getHourOfDay()).thenReturn(hourOfDay);
    SayHello sayHello = new SayHello(timeProvider);
    String hello = sayHello.sayHello();
    assertThat(hello).isEqualTo("Good after noon !");
  }

  @ParameterizedTest
  @MethodSource("dataProvider")
  void should_get_arguments_from_data_provider(String name, int age, int zipCode) {
    System.out.println(name + " " + age + " " + zipCode);
  }

  @Test
  void should_say_good_morning_when_morning() {
    //Given
    BDDMockito.given(timeProvider.getHourOfDay()).willReturn(10);

    //When
    String hello = sayHello.sayHello();

    //Then
    assertThat(hello).isEqualTo("Good morning !");
  }
}
