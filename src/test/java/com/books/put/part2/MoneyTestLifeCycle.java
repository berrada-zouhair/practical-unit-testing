package com.books.put.part2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoneyTestLifeCycle {

  public MoneyTestLifeCycle() {
    System.out.println("INSIDE CONSTRUCTOR");
  }

  @BeforeAll
  static void globalSetUp() {
    System.out.println("Inside globalSetUp()");
  }

  @BeforeEach
  void setUp() {
    System.out.println("Inside setUp()");
  }

  @Test
  void dummy_test_1() {
    System.out.println("dummy_test_1");
  }

  @Test
  void dummy_test_2() {
    System.out.println("dummy_test_2");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Inside tearDown()");
  }

  @AfterAll
  static void globalTearDown() {
    System.out.println("Inside globalTearDown()");
  }
}
