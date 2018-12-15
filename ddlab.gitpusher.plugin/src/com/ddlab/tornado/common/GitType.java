//package com.ddlab.tornado.common;
//
//import com.ddlab.gitpusher.bitbucket.core.BitBucketHandlerImpl;
//import com.ddlab.gitpusher.bitbucket.core.BitBucketPusherImpl;
//import com.ddlab.gitpusher.core.IGitHandler;
//import com.ddlab.gitpusher.core.IGitPusher;
//import com.ddlab.gitpusher.core.UserAccount;
//import com.ddlab.gitpusher.github.core.GitHubHandlerImpl;
//import com.ddlab.gitpusher.github.core.GitHubPusherImpl;
//
//@Deprecated
//public enum GitType {
//  GITHUB("GitHub") {
//    public IGitPusher getGitPusher(UserAccount userAccount) {
//      IGitHandler gitHandler = new GitHubHandlerImpl(userAccount);
//      return new GitHubPusherImpl(gitHandler);
//    }
//  },
//
//  BITBUCKET("Bitbucket") {
//    public IGitPusher getGitPusher(UserAccount userAccount) {
//      IGitHandler gitHandler = new BitBucketHandlerImpl(userAccount);
//      return new BitBucketPusherImpl(gitHandler);
//    }
//  };
//
//  private String gitType;
//
//  private GitType(String gitType) {
//    this.gitType = gitType;
//  }
//
//  public String getGitType() {
//    return gitType;
//  }
//
//  public static GitType fromString(String text) {
//    for (GitType type : GitType.values()) {
//      if (text.equalsIgnoreCase(type.gitType)) return type;
//    }
//    return null;
//  }
//
//  public abstract IGitPusher getGitPusher(UserAccount userAccount);
//}
