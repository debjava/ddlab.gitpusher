/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.core;

/**
 * The Class UserAccount.
 *
 * @author Debadatta Mishra
 */
public class UserAccount {

  /** The user name. */
  private String userName;

  /** The password. */
  private String password;

  /**
   * Instantiates a new user account.
   *
   * @param userName the user name
   * @param password the password
   */
  public UserAccount(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  /**
   * Gets the user name.
   *
   * @return the user name
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the user name.
   *
   * @param userName the new user name
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Gets the password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password.
   *
   * @param password the new password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "UserAccount{" + "userName='" + userName + '\'' + ", password='" + password + '\'' + '}';
  }
}
