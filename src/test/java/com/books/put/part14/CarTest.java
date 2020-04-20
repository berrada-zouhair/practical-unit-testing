package com.books.put.part14;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  private static Stream<Color> getNonRedColors() {
    return Stream.of(Color.values()).filter(color -> !Color.RED.equals(color));
  }

  @Test
  void car_should_be_sport_when_is_red_and_count_cylinders_6_and_manufactured_by_ferrari() {
    Engine engineWithSixCylinders = when(mock(Engine.class).getCountCylinders())
        .thenReturn(6)
        .getMock();
    Manufacturer ferrariManufacturer = when(mock(Manufacturer.class).getName())
        .thenReturn("Ferrari")
        .getMock();
    Color redColor = Color.RED;
    Car car = new Car(redColor, ferrariManufacturer, engineWithSixCylinders);
    assertThat(car.isSport()).isTrue();
  }

  @Test
  void car_should_not_be_sport_when_is_red_and_count_cylinders_6_and_not_manufactured_by_ferrari() {
    Engine engineWithSixCylinders = when(mock(Engine.class).getCountCylinders())
        .thenReturn(6)
        .getMock();
    Manufacturer ferrariManufacturer = when(mock(Manufacturer.class).getName())
        .thenReturn("Mercedes")
        .getMock();
    Color redColor = Color.RED;
    Car car = new Car(redColor, ferrariManufacturer, engineWithSixCylinders);
    assertThat(car.isSport()).isFalse();
  }

  @ParameterizedTest
  @MethodSource("getNonRedColors")
  void car_should_not_be_sport_when_is_not_red_and_count_cylinders_6_and_manufactured_by_ferrari(Color nonRedColor) {
    Engine engineWithSixCylinders = when(mock(Engine.class).getCountCylinders())
        .thenReturn(6)
        .getMock();
    Manufacturer ferrariManufacturer = when(mock(Manufacturer.class).getName())
        .thenReturn("Mercedes")
        .getMock();
    Car car = new Car(nonRedColor, ferrariManufacturer, engineWithSixCylinders);
    assertThat(car.isSport()).isFalse();
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 7, 8 ,9, 10})
  void car_should_not_be_sport_when_is_red_and_count_cylinders_not_6_and_manufactured_by_ferrari(int nonSixCylinders) {
    Engine engineWithSixCylinders = when(mock(Engine.class).getCountCylinders())
        .thenReturn(nonSixCylinders)
        .getMock();
    Manufacturer ferrariManufacturer = when(mock(Manufacturer.class).getName())
        .thenReturn("Ferrari")
        .getMock();
    Color redColor = Color.RED;
    Car car = new Car(redColor, ferrariManufacturer, engineWithSixCylinders);
    assertThat(car.isSport()).isFalse();
  }

}