package com.books.put.part14;

public class Car {

  private final Color color;
  private final Manufacturer manufacturer;
  private final Engine engine;

  public Car(Color color, Manufacturer manufacturer, Engine engine) {
    this.color = color;
    this.manufacturer = manufacturer;
    this.engine = engine;
  }

  public boolean isSport() {
    return Color.RED.equals(color)
        && "Ferrari".equals(manufacturer.getName())
        && engine.getCountCylinders() == 6;
  }
}
