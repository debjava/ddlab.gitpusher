package com.ddlab.gitpusher.bitbucket.core;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.core.NoGitHandler;
import com.ddlab.gitpusher.core.YesGitHandler;
import com.ddlab.gitpusher.exception.GenericGitPushException;
import com.ddlab.gitpusher.github.core.NoGitHubHandlerImpl;
import com.ddlab.gitpusher.github.core.YesGitHubHandlerImpl;

import java.io.File;

public class BitBucketPusherImpl implements IGitPusher {
  private IGitHandler gitHandler;
  private NoGitHandler noGitHandler;
  private YesGitHandler yesGitHandler;

  public BitBucketPusherImpl(IGitHandler gitHandler) {
    this.gitHandler = gitHandler;
    noGitHandler = new NoBitBucketGitHandler();
    yesGitHandler = new YesBitBucketGitHandler();
  }

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

  @Override
  public void pushSnippetDirectly(File file, String description) throws GenericGitPushException {
    try {
      gitHandler.createGist(file, description);
    } catch (Exception e) {
      throw new GenericGitPushException(e.getMessage());
    }
  }

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
