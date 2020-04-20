package com.books.put.part13;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InjectMocksTest {

  @InjectMocks
  private MySut mySut;

  @Mock
  private Collaborator collaborator;

  @Test
  void use_collaborator_should_return_abc() {
    Mockito.when(collaborator.doSomeThing()).thenReturn("abc");
    String result = mySut.useCollaborato();
    Assertions.assertThat(result).isEqualTo("abc");
  }

}
