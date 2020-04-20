package com.books.put.part12;

import java.util.Date;

public class Meeting {

  private final Date startTime;
  private final Date endTime;

  public Meeting(Date startTime, Date endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Date getStartTime() {
    return startTime;
  }

  public Date getEndTime() {
    return endTime;
  }
}
