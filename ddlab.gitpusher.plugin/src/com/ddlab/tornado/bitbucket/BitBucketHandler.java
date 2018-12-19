/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.tornado.bitbucket;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.UserAccount;
import com.ddlab.tornado.exceptions.SnippetException;

/**
 * The Class BitBucketHandler.
 *
 * @author Debadatta Mishra
 */
public class BitBucketHandler {

  /** The user account. */
  private UserAccount userAccount;
  
  /** The git hub handler. */
  private IGitHandler gitHubHandler;

  /**
   * Instantiates a new bit bucket handler.
   *
   * @param userAccount the user account
   * @param gitHubHandler the git hub handler
   */
  public BitBucketHandler(UserAccount userAccount, IGitHandler gitHubHandler) {
    super();
    this.userAccount = userAccount;
    this.gitHubHandler = gitHubHandler;
  }

  /**
   * Gets the user account.
   *
   * @return the user account
   */
  public UserAccount getUserAccount() {
    return userAccount;
  }

  /**
   * Gets the git hub handler.
   *
   * @return the git hub handler
   */
  public IGitHandler getGitHubHandler() {
    return gitHubHandler;
  }

  /**
   * Handle snippet.
   *
   * @return the string[]
   * @throws SnippetException the snippet exception
   */
  public String[] handleSnippet() throws SnippetException {
    String[] snippets = null;
    try {
      snippets = gitHubHandler.getGists();
    } catch (Exception e) {
      throw new SnippetException(e);
    }
    return snippets;
  }
}
