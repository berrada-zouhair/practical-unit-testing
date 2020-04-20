package com.books.put.part5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ClientTest {

  private static Phone MOBILE_PHONE;
  private static Phone STATIONARY_PHONE;
  private static String ANY_PHONE_NUMBER;

  @BeforeAll
  static void setUp() {
    ANY_PHONE_NUMBER = "0123456789";
    MOBILE_PHONE = new Phone(ANY_PHONE_NUMBER, true);
    STATIONARY_PHONE = new Phone(ANY_PHONE_NUMBER, false);
  }

  @Test
  void should_return_true_if_client_has_mobile() {
    ClientWithPhone client = new ClientWithPhone();
    client.addPhone(MOBILE_PHONE);
    client.addPhone(STATIONARY_PHONE);
    assertThat(client.hasMobile()).isTrue();
  }

  @Test
  void should_return_false_when_client_has_no_phone() {
    ClientWithPhone client = new ClientWithPhone();
    assertThat(client.hasMobile()).as("portable").isFalse();
  }

  @Test
  void should_return_false_when_client_has_no_mobile() {
    ClientWithPhone client = new ClientWithPhone();
    client.addPhone(STATIONARY_PHONE);
    assertThat(client.hasMobile()).isFalse();
  }
}
