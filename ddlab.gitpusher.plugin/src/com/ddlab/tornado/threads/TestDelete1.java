//package com.ddlab.tornado.threads;
//
//import com.ddlab.gitpusher.core.IGitPusher;
//import com.ddlab.gitpusher.core.UserAccount;
//
//public class TestDelete1 {
//	
//	  private static String userName = "sambittechy@gmail.com";
//	  private static String password = "abcd@1234";
//
//  public static void main(String[] args) throws Exception {
//	  UserAccount userAccount = new UserAccount(userName, password);
//	  IGitPusher gitPusher = GitType.fromString("gitHub").getGitPusher(userAccount);
//	  String[] snippets = gitPusher.getExistingSnippets();
//	  for( String s : snippets)
//		  System.out.println(s ); 
//
//  }
//}
