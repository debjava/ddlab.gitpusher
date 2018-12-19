/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.core;

import com.ddlab.gitpusher.bitbucket.core.BitBucketHandlerImpl;
import com.ddlab.gitpusher.bitbucket.core.BitBucketPusherImpl;
import com.ddlab.gitpusher.github.core.GitHubHandlerImpl;
import com.ddlab.gitpusher.github.core.GitHubPusherImpl;

/**
 * The Enum GitType.
 *
 * @author Debadatta Mishra
 */
public enum GitType {

  /** The github. */
  GITHUB("GitHub") {
    public IGitPusher getGitPusher(UserAccount userAccount) {
      IGitHandler gitHandler = new GitHubHandlerImpl(userAccount);
      return new GitHubPusherImpl(gitHandler);
    }
  },

  /** The bitbucket. */
  BITBUCKET("Bitbucket") {
    public IGitPusher getGitPusher(UserAccount userAccount) {
      IGitHandler gitHandler = new BitBucketHandlerImpl(userAccount);
      return new BitBucketPusherImpl(gitHandler);
    }
  };

  /** The git type. */
  private String gitType;

  /**
   * Instantiates a new git type.
   *
   * @param gitType the git type
   */
  private GitType(String gitType) {
    this.gitType = gitType;
  }

  /**
   * Gets the git type.
   *
   * @return the git type
   */
  public String getGitType() {
    return gitType;
  }

  /**
   * From string.
   *
   * @param text the text
   * @return the git type
   */
  public static GitType fromString(String text) {
    for (GitType type : GitType.values()) {
      if (text.equalsIgnoreCase(type.gitType)) return type;
    }
    return null;
  }

  /**
   * Gets the git pusher.
   *
   * @param userAccount the user account
   * @return the git pusher
   */
  public abstract IGitPusher getGitPusher(UserAccount userAccount);
}
