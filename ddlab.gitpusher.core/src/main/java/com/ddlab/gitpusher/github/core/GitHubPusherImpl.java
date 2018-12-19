/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.core.NoGitHandler;
import com.ddlab.gitpusher.core.YesGitHandler;
import com.ddlab.gitpusher.exception.GenericGitPushException;

import java.io.File;

/**
 * The Class GitHubPusherImpl.
 *
 * @author Debadatta Mishra
 */
public class GitHubPusherImpl implements IGitPusher {

  /** The git hub handler. */
  private IGitHandler gitHubHandler;

  /** The no git handler. */
  private NoGitHandler noGitHandler;

  /** The yes git handler. */
  private YesGitHandler yesGitHandler;

  /**
   * Instantiates a new git hub pusher impl.
   *
   * @param gitHubHandler the git hub handler
   */
  public GitHubPusherImpl(IGitHandler gitHubHandler) {
    this.gitHubHandler = gitHubHandler;
    noGitHandler = new NoGitHubHandlerImpl();
    yesGitHandler = new YesGitHubHandlerImpl();
  }

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IGitPusher#pushCodeDirectly(java.io.File)
   */
  @Override
  public void pushCodeDirectly(File projectDir) throws GenericGitPushException {
    try {
      boolean isGitAvailable = gitHubHandler.isGitDirAvailable(projectDir);
      if (isGitAvailable) {
        yesGitHandler.handle(projectDir, gitHubHandler);
      } else {
        noGitHandler.handle(projectDir, gitHubHandler);
      }
    } catch (Exception e) {
      throw new GenericGitPushException(e.getMessage());
    }
  }

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IGitPusher#pushSnippetDirectly(java.io.File, java.lang.String)
   */
  public void pushSnippetDirectly(File file, String description) throws GenericGitPushException {
    try {
      gitHubHandler.createGist(file, description);
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
      existingRepos = gitHubHandler.getAllRepositories();
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
      existingSnippets = gitHubHandler.getGists();
    } catch (Exception e) {
      throw new GenericGitPushException(e.getMessage());
    }
    return existingSnippets;
  }
}
