package com.books.put.part5;

import static org.mockito.Mockito.mock;

import com.books.put.part5.section7.SecurityService;
import com.books.put.part5.section7.User;
import com.books.put.part5.section7.UserDao;
import com.books.put.part5.section7.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserServiceTest {

  @Test
  void should_update_user_password() {
    UserDao userDao = mock(UserDao.class);
    SecurityService securityService = mock(SecurityService.class);
    UserServiceImpl userService = new UserServiceImpl(userDao, securityService);
    User user = mock(User.class);

    String password = "aPassword";
    String passwordHash = "aNewPasswordHash";
    Mockito.when(user.getPassword()).thenReturn(password);
    Mockito.when(securityService.md5(password)).thenReturn(passwordHash);

    userService.assignPassword(user);
    Mockito.verify(securityService).md5(password);
    Mockito.verify(user).setPassword(passwordHash);
    Mockito.verify(userDao).updateUser(user);
  }
}
