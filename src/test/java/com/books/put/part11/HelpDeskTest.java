package com.books.put.part11;

import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HelpDeskTest {

  private static TimeProvider timeProvider;
  private static Issue issue;
  private static HelpDesk helpDesk;

  @BeforeAll
  static void init() {
    timeProvider = mock(TimeProvider.class);
    issue = mock(Issue.class);
    helpDesk = new HelpDesk(timeProvider);
  }

  @ParameterizedTest
  @ValueSource(ints = {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY})
  void should_handle_issue_when_not_weekend_and_not_friday_after_5_pm(int dayOfWeek) {
    when(timeProvider.getDayOfWeek()).thenReturn(dayOfWeek);
    when(timeProvider.getHourOfDay()).thenReturn(11);
    boolean isHandled = helpDesk.handle(issue);
    assertThat(isHandled).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17})
  void should_handle_issue_when_friday_before_6_pm(int hourOfDay) {
    when(timeProvider.getDayOfWeek()).thenReturn(FRIDAY);
    when(timeProvider.getHourOfDay()).thenReturn(hourOfDay);
    boolean isHandled = helpDesk.handle(issue);
    assertThat(isHandled).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {18, 19, 20, 21, 22, 23})
  void should_not_handle_issue_on_friday_after_5_pm(int hourOfDay) {
    when(timeProvider.getHourOfDay()).thenReturn(hourOfDay);
    when(timeProvider.getDayOfWeek()).thenReturn(FRIDAY);
    boolean isHandled = helpDesk.handle(issue);
    assertThat(isHandled).isFalse();
  }

  @ParameterizedTest
  @ValueSource(ints = {SATURDAY, SUNDAY})
  void should_not_handle_issue_on_weekend(int dayOfWeek) {
    when(timeProvider.getDayOfWeek()).thenReturn(dayOfWeek);
    boolean isHandled = helpDesk.handle(issue);
    assertThat(isHandled).isFalse();
  }
}
