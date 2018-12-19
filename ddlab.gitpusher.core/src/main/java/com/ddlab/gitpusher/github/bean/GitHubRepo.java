/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.github.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * The Class GitHubRepo.
 *
 * @author Debadatta Mishra
 */
public class GitHubRepo {

  /** The repos. */
  private Repo[] repos;

  /** The clone url. */
  @JsonProperty("clone_url")
  private String cloneUrl;

  /** The login user. */
  @JsonProperty("login")
  private String loginUser;

  /** Instantiates a new git hub repo. */
  public GitHubRepo() {}

  /**
   * Gets the repos.
   *
   * @return the repos
   */
  public Repo[] getRepos() {
    return repos;
  }

  /**
   * Sets the repos.
   *
   * @param repos the new repos
   */
  public void setRepos(Repo[] repos) {
    this.repos = repos;
  }

  /**
   * Gets the login user.
   *
   * @return the login user
   */
  public String getLoginUser() {
    return loginUser;
  }

  /**
   * Sets the login user.
   *
   * @param loginUser the new login user
   */
  public void setLoginUser(String loginUser) {
    this.loginUser = loginUser;
  }

  /**
   * Gets the clone url.
   *
   * @return the clone url
   */
  public String getCloneUrl() {
    return cloneUrl;
  }

  /**
   * Sets the clone url.
   *
   * @param cloneUrl the new clone url
   */
  public void setCloneUrl(String cloneUrl) {
    this.cloneUrl = cloneUrl;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "GitHubRepo{"
        + "repos="
        + Arrays.toString(repos)
        + ", cloneUrl='"
        + cloneUrl
        + '\''
        + ", loginUser='"
        + loginUser
        + '\''
        + '}';
  }
}
