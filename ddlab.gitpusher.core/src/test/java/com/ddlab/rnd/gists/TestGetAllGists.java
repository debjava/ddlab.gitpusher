package com.ddlab.rnd.gists;

import com.ddlab.gitpusher.core.GitType;
import com.ddlab.gitpusher.core.IGitPusher;
import com.ddlab.gitpusher.core.UserAccount;

public class TestGetAllGists {
  private static String userName = "sambittechy@gmail.com";
  private static String password = "abcd@1234";

  public static void main(String[] args) throws Exception {

    UserAccount userAccount = new UserAccount(userName, password);
    IGitPusher gitPusher = GitType.fromString("bitbucket").getGitPusher(userAccount);
    gitPusher.getExistingSnippets();
  }
}
