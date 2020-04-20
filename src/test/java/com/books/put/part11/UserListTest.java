package com.books.put.part11;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserListTest {

  private static User user1;
  private static User user2;

  @BeforeAll
  static void setUp() {
    user1 = Mockito.mock(User.class, "User1");
    user2 = Mockito.mock(User.class, "User2");
  }

  @Test
  void should_return_an_empty_list_of_users_when_no_user_is_added() {
    UserList userList = new UserList();
    List<User> users = userList.getUsers();
    Assertions.assertThat(users).isNotNull().hasSize(0);
  }

  @Test
  void should_return_a_list_of_one_user_when_one_is_added() {
    UserList userList = new UserList();
    userList.addUser(user1);
    Assertions.assertThat(userList.getUsers())
        .isNotNull()
        .isNotEmpty()
        .hasSize(1)
        .containsExactly(user1)
        .containsOnly(user1);
  }

  @Test
  void should_return_a_list_of_two_users_when_two_are_added() {
    UserList userList = new UserList();
    userList.addUser(user1);
    userList.addUser(user2);
    Assertions.assertThat(userList.getUsers())
        .isNotNull()
        .isNotEmpty()
        .hasSize(2)
        .containsAll(Arrays.asList(user1, user2))
        .hasOnlyElementsOfTypes(User.class);
  }
}
