package com.books.put.part11;

import java.util.ArrayList;
import java.util.List;

public class UserList {

  List<User> users = new ArrayList<>(10);

  public List<User> getUsers() {
    return users;
  }

  public void addUser(User user) {
    users.add(user);
  }
}
