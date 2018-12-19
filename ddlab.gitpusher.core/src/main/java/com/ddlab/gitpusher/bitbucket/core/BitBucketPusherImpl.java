/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.bitbucket.core;

import java.io.File;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.core.NoGitHandler;
import com.ddlab.gitpusher.core.YesGitHandler;
import com.ddlab.gitpusher.exception.GenericGitPushException;

/**
 * The Class BitBucketPusherImpl.
 *
 * @author Debadatta Mishra
 */
public class BitBucketPusherImpl implements IGitPusher {

  /** The git handler. */
  private IGitHandler gitHandler;

  /** The no git handler. */
  private NoGitHandler noGitHandler;

  /** The yes git handler. */
  private YesGitHandler yesGitHandler;

  /**
   * Instantiates a new bit bucket pusher impl.
   *
   * @param gitHandler the git handler
   */
  public BitBucketPusherImpl(IGitHandler gitHandler) {
    this.gitHandler = gitHandler;
    noGitHandler = new NoBitBucketGitHandler();
    yesGitHandler = new YesBitBucketGitHandler();
  }

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IGitPusher#pushCodeDirectly(java.io.File)
   */
  @Override
  public void pushCodeDirectly(File projectDir) throws GenericGitPushException {
    try {
      boolean isGitAvailable = gitHandler.isGitDirAvailable(projectDir);
      if (isGitAvailable) {
        // Handle it differently
        // YesGitHanlder
        yesGitHandler.handle(projectDir, gitHandler);
      } else {
        // No git Handler
        noGitHandler.handle(projectDir, gitHandler);
      }
    } catch (Exception e) {
      throw new GenericGitPushException(e.getMessage());
    }
  }

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IGitPusher#pushSnippetDirectly(java.io.File, java.lang.String)
   */
  @Override
  public void pushSnippetDirectly(File file, String description) throws GenericGitPushException {
    try {
      gitHandler.createGist(file, description);
    } catch (Exception e) {
      throw new GenericGitPushException(e.getMessage());
    }
  }

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IGitPusher#getExistingRepos()
   */
  @Override
  public String[] getExistingRepos() throws GenericGitPushException {
    String[] existingRepos = null;
    try {
      existingRepos = gitHandler.getAllRepositories();
    } catch (Exception e) {
      throw new GenericGitPushException(e.getMessage());
    }

    return existingRepos;
  }

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IGitPusher#getExistingSnippets()
   */
  @Override
  public String[] getExistingSnippets() throws GenericGitPushException {
    String[] existingSnippets = null;
    try {
      existingSnippets = gitHandler.getGists();
    } catch (Exception e) {
      throw new GenericGitPushException(e.getMessage());
    }
    return existingSnippets;
  }
}
