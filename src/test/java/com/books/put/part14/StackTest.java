package com.books.put.part14;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {

  private Stack<String> stack;

  private String ANY_STRING;

  @BeforeEach
  void setUp() {
    stack = new Stack<>();
    ANY_STRING = "ANY_STRING";
  }

  @Test
  void stack_should_be_empty_when_created() {
    assertThat(stack.isEmpty()).isTrue();
  }

  @Test
  void stack_should_have_size_zero_when_created() {
    assertThat(stack.size()).isEqualTo(0);
  }

  @Test
  void should_push_element_and_increment_size() {
    stack.push(ANY_STRING);
    assertThat(stack.isEmpty()).isFalse();
    assertThat(stack.size()).isEqualTo(1);
    assertThat(stack.peek().isPresent()).isTrue();
    assertThat(stack.peek().get()).isEqualTo(ANY_STRING);
  }

  @Test
  void should_pop_element_and_decrease_size() {
    stack.push(ANY_STRING);
    assertThat(stack.pop()).isEqualTo(ANY_STRING);
    assertThat(stack.isEmpty()).isTrue();
    assertThat(stack.size()).isEqualTo(0);
    assertThat(stack.peek().isPresent()).isFalse();
  }

  @Test
  void should_throw_ISE_when_pop_empty_stack() {
    assertThatIllegalStateException().isThrownBy(
        () -> stack.pop()
    );
  }

  @Test
  void should_return_empty_optional_when_peek_on_empty_stack() {
    assertThat(stack.peek().isPresent()).isFalse();
  }
}
