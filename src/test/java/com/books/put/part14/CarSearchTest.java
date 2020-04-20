package com.books.put.part14;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarSearchTest {

  private CarSearch carSearch;

  @BeforeEach
  void setUp() {
    carSearch = new CarSearch();
  }

  @Test
  void should_add_a_car() {
    Car car = mock(Car.class);
    carSearch.add(car);
    assertThat(carSearch.getCars())
        .isNotNull()
        .isNotEmpty()
        .hasSize(1)
        .containsOnly(car);
  }

  @Test
  void should_return_sport_cars() {
    //Given
    Car sportCar1 = when(mock(Car.class).isSport()).thenReturn(true).getMock();
    Car sportCar2 = when(mock(Car.class).isSport()).thenReturn(true).getMock();
    Car nonSportCar3 = when(mock(Car.class).isSport()).thenReturn(false).getMock();
    carSearch.add(sportCar1);
    carSearch.add(sportCar2);
    carSearch.add(nonSportCar3);

    //When
    List<Car> sportCars = carSearch.getSportCars();

    //Then
    assertThat(sportCars)
        .isNotNull()
        .isNotEmpty()
        .hasSize(2)
        .containsOnly(sportCar1, sportCar2)
        .doesNotContain(nonSportCar3);
  }
}
