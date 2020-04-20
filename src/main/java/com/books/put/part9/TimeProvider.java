package com.books.put.part9;

import java.util.Calendar;

public class TimeProvider {

  public int getHourOfDay() {
    Calendar calendar = Calendar.getInstance();
    return calendar.get(Calendar.HOUR_OF_DAY);
  }

}
