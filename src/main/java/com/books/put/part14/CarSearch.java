package com.books.put.part14;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class CarSearch {

  private List<Car> cars = new ArrayList<>();

  public void add(Car car) {
    cars.add(car);
  }

  public List<Car> getCars() {
    return cars;
  }

  public List<Car> getSportCars() {
    return cars.stream().filter(Car::isSport).collect(toList());
  }
}
