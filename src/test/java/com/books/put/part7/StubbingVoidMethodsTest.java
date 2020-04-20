package com.books.put.part7;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StubbingVoidMethodsTest {

  @Test
  void add_String_should_throw_IAE() {
    List<String> list = mock(List.class);
    String aString = "aString";
    Mockito.doThrow(IllegalArgumentException.class).when(list).add(0, aString);

    Assertions.assertThatIllegalArgumentException().isThrownBy(
        () -> list.add(0, aString)
    );
  }

  @Test
  @Disabled
  void draft_test() {
    ArrayList<String> strings = spy(ArrayList.class);
    Mockito.doCallRealMethod().when(strings).add(isA(String.class));
    Mockito.doReturn("STRING").when(strings).get(anyInt());
    strings.add("1");
    strings.add("2");
    Assertions.assertThat(strings.size()).isEqualTo(2);
    Assertions.assertThat(strings.get(0)).isEqualTo("STRING");
    Assertions.assertThat(strings.get(Integer.MAX_VALUE)).isEqualTo("STRING");
  }
}
