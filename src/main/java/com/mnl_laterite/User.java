package com.mnl_laterite;

public class User {

  private String username;
  private String passwordSalt;
  private String encryptedPassword;

  User (String username, String passwordSalt, String encryptedPassword) {

    this.username = username;
    this.passwordSalt = passwordSalt;
    this.encryptedPassword = encryptedPassword;
  }

  String getPasswordSalt() {
    return this.passwordSalt;
  }

  String getEncryptedPassword() {
    return this.encryptedPassword;
  }

  String getUsername() {
    return this.username;
  }

}
