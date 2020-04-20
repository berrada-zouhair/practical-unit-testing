package com.books.put.part11;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class OperatingSystemAssert extends AbstractAssert<OperatingSystemAssert, OperatingSystem> {

  public OperatingSystemAssert(OperatingSystem operatingSystem) {
    super(operatingSystem, OperatingSystemAssert.class);
  }

  public static OperatingSystemAssert assertThat(OperatingSystem operatingSystem) {
    return new OperatingSystemAssert(operatingSystem);
  }

  public OperatingSystemAssert is128bit() {
    Assertions.assertThat(actual).isNotNull();
    Assertions.assertThat(actual.getNbrOfBites()).isEqualTo(128);
    return this;
  }

  public OperatingSystemAssert wasReleasedIn(int year) {
    Assertions.assertThat(actual).isNotNull();
    Assertions.assertThat(actual.getReleaseYear()).isEqualTo(year);
    return this;
  }

  public OperatingSystemAssert hasVersion(int version) {
    Assertions.assertThat(actual).isNotNull();
    Assertions.assertThat(actual.getVersion()).isEqualTo(version);
    return this;
  }

}
