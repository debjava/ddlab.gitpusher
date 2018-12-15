package com.ddlab.rnd.gists;

import com.ddlab.gitpusher.core.GitType;
import com.ddlab.gitpusher.core.UserAccount;

public class TestGitType {
  private static String userName = "sambittechy@gmail.com";
  private static String password = "abcd@1234";

  public static void main(String[] args) throws Exception {
    GitType typo = GitType.fromString("github");
    UserAccount userAccount = new UserAccount(userName, password);
    String[] snippets = typo.getGitPusher(userAccount).getExistingSnippets();
    for(String s : snippets)
    	System.out.println(s ); 

//    System.out.println(typo);
//    System.out.println(typo.getGitPusher(null));
  }
}
