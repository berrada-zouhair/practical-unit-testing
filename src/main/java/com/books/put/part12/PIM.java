package com.books.put.part12;

import java.util.Date;

public class PIM {

  private Calendar calendar;

  public PIM(Calendar calendar) {
    this.calendar = calendar;
  }

  public void addMeeting(Date startTime, int durationInHours) {
    calendar.add(new Meeting(startTime, new Date(startTime.getTime() + durationInHours * 60 * 1000)));
  }
}
