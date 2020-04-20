package com.books.put.part13;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OneLineStubbingTest {

  private MySut mySut;

  private Collaborator collaborator;

  @BeforeEach
  void setUp() {
    collaborator = Mockito.when(Mockito.mock(Collaborator.class).doSomeThing())
        .thenReturn("abc")
        .getMock();
    mySut = new MySut();
    mySut.setCollaborator(collaborator);
  }

  @Test
  void use_collaborator_should_return_abc() {
    String result = mySut.useCollaborato();
    Assertions.assertThat(result).isEqualTo("abc");
  }
}
