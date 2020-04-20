package com.books.put.part11;

import java.util.Calendar;

public class HelpDesk {

  private final static int END_OF_OFFICE = 17;
  private TimeProvider timeProvider;

  public HelpDesk(TimeProvider timeProvider) {
    this.timeProvider = timeProvider;
  }

  public boolean handle(Issue issue) {
    int hourOfDay = timeProvider.getHourOfDay();
    int dayOfWeek = timeProvider.getDayOfWeek();
    if (isWeekEnd(dayOfWeek) || isFridayAfterFivePm(hourOfDay, dayOfWeek)) {
      return false;
    }
    //process issue
    return true;
  }

  private boolean isFridayAfterFivePm(int hourOfDay, int dayOfWeek) {
    return hourOfDay > END_OF_OFFICE && dayOfWeek == Calendar.FRIDAY;
  }

  private boolean isWeekEnd(int dayOfWeek) {
    return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
  }
}
