package com.books.put.part11;

import org.junit.jupiter.api.Test;

public class OperatingSystemTest {

  @Test
  void should_assign_constructor_params() {
    OperatingSystem operatingSystem = new OperatingSystem();
    OperatingSystemAssert.assertThat(operatingSystem)
        .hasVersion(9)
        .is128bit()
        .wasReleasedIn(2019);
  }
}
