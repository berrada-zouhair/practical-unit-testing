package com.books.put.part5.section7;

public class UserServiceImpl {

  private final UserDao userDao;
  private final SecurityService securityService;

  public UserServiceImpl(UserDao userDao, SecurityService securityService) {
    this.userDao = userDao;
    this.securityService = securityService;
  }

  public void assignPassword(User user) {
    String passwordMd5 = securityService.md5(user.getPassword());
    user.setPassword(passwordMd5);
    userDao.updateUser(user);
  }
}
