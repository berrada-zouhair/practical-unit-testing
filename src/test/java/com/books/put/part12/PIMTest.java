package com.books.put.part12;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class PIMTest {

  private Calendar calendar;
  private PIM pim;
  private Date meetingStartTime;
  private int ONE_HOUR;
  private Date meetingEndTime;

  @BeforeEach
  void setUp() {
    calendar = Mockito.mock(Calendar.class);
    pim = new PIM(calendar);
    ONE_HOUR = 60;
    meetingStartTime = new Date();
    meetingEndTime = new Date(meetingStartTime.getTime() + ONE_HOUR * 60 * 1000);
  }

  @Test
  void should_add_event_to_calendar_with_reflexion() {
    pim.addMeeting(meetingStartTime, ONE_HOUR);
    Meeting addedMeeting = new Meeting(meetingStartTime, meetingEndTime);
    Mockito.verify(calendar).add(ArgumentMatchers.refEq(addedMeeting));
  }

  @Test
  void should_add_event_to_calendar_with_argument_captor() {
    pim.addMeeting(meetingStartTime, ONE_HOUR);

    ArgumentCaptor<Meeting> argumentCaptor = ArgumentCaptor.forClass(Meeting.class);
    Mockito.verify(calendar).add(argumentCaptor.capture());

    Meeting actual = argumentCaptor.getValue();
    Meeting expected = new Meeting(meetingStartTime, meetingEndTime);

    assertThat(actual).isEqualToComparingFieldByField(expected);
  }

  @Test
  void should_add_event_to_calendar_with_hamcrest() {
    pim.addMeeting(meetingStartTime, ONE_HOUR);
    Meeting addedMeeting = new Meeting(meetingStartTime, meetingEndTime);
    Mockito.verify(calendar).add(ArgumentMatchers.argThat(meeting ->
        meeting.getEndTime().equals(addedMeeting.getEndTime()) &&
            meeting.getStartTime().equals(addedMeeting.getStartTime())));
  }
}
