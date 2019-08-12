package com.mnl_laterite;

import org.mindrot.jbcrypt.BCrypt;
import static com.mnl_laterite.App.userService;

public class UserController {

  public static boolean authenticate (String username, String password) {

    if (username == null || password == null) {
      return false;
    }

    User user = userService.getUserByUsername(username);

    if (user == null) {
      return false;
    }

    String encryptedPassword = BCrypt.hashpw(password, user.getPasswordSalt());
    return encryptedPassword.equals(user.getEncryptedPassword());
  }

}
