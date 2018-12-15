package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.core.NoGitHandler;
import com.ddlab.gitpusher.core.YesGitHandler;
import com.ddlab.gitpusher.exception.GenericGitPushException;

import java.io.File;

public class GitHubPusherImpl implements IGitPusher {
  private IGitHandler gitHubHandler;
  private NoGitHandler noGitHandler;
  private YesGitHandler yesGitHandler;

  public GitHubPusherImpl(IGitHandler gitHubHandler) {
    this.gitHubHandler = gitHubHandler;
    noGitHandler = new NoGitHubHandlerImpl();
    yesGitHandler = new YesGitHubHandlerImpl();
  }

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
//      throw new GenericGitPushException("Exception while pushing code to GIT", e);
    }
  }

  public void pushSnippetDirectly(File file, String description) throws GenericGitPushException {
    try {
      gitHubHandler.createGist(file, description);
    } catch (Exception e) {
      throw new GenericGitPushException(e.getMessage());
    }
  }

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
