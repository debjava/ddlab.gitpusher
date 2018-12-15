package com.ddlab.tornado.bitbucket;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.UserAccount;
import com.ddlab.tornado.exceptions.SnippetException;

public class BitBucketHandler {

  private UserAccount userAccount;
  private IGitHandler gitHubHandler;

  public BitBucketHandler(UserAccount userAccount, IGitHandler gitHubHandler) {
    super();
    this.userAccount = userAccount;
    this.gitHubHandler = gitHubHandler;
  }

  public UserAccount getUserAccount() {
    return userAccount;
  }

  public IGitHandler getGitHubHandler() {
    return gitHubHandler;
  }

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
