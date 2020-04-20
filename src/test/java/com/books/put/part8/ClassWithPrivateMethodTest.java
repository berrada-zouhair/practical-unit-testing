package com.books.put.part8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

public class ClassWithPrivateMethodTest {

  @Test
  void should_private_method_return_true()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    ClassWithPrivateMethod classWithPrivateMethod = new ClassWithPrivateMethod();
    Method privateMethod = classWithPrivateMethod.getClass()
        .getDeclaredMethod("privateMethod", Long.class);
    ReflectionUtils.makeAccessible(privateMethod);
    boolean returnedValue = (boolean) privateMethod.invoke(classWithPrivateMethod, 1L);
    Assertions.assertThat(returnedValue).isTrue();
  }
}
