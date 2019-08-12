package com.mnl_laterite;

public class UserService {

  private final User user = new User("user",
                                     "$2a$10$h.dl5J86rGH7I8bD9bZeZe",
                                     "$2a$10$h.dl5J86rGH7I8bD9bZeZeci0pDt0.VwFTGujlnEaZXPf/q7vM5wO");

  User getUserByUsername(String username) {
    if ("user".equals(username)) {
      return this.user;
    } else {
      return null;
    }
  }

}
