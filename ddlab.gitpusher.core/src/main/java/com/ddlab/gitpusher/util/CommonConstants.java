/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.util;

/**
 * The Class CommonConstants.
 *
 * @author Debadatta Mishra
 */
public class CommonConstants {
  // Product Specific

  /** The Constant GENERIC_COMIT_MSG. */
  public static final String GENERIC_COMIT_MSG =
      "Code committed and pushed by {0} "
          + "on "
          + CommonUtil.getTodayDateTime()
          + " "
          + "using DDLAB Gitpusher tool";

  /** The Constant GENERIC_LOGIN_ERR_MSG. */
  public static final String GENERIC_LOGIN_ERR_MSG =
      "Inappropriate credentials, check your user name and password combination";

  /** The Constant GENERIC_LOCAL_GIT_EXIST. */
  public static final String GENERIC_LOCAL_GIT_EXIST =
      "Unable to read the local .git directory to find out the Repo URL";

  /** The Constant NO_CONNECTION_MSG. */
  public static final String NO_CONNECTION_MSG = "Unable to connect ...";

  /** The Constant GITHUB_GIST_ERR_MSG. */
  // GITHUB Details
  public static final String GITHUB_GIST_ERR_MSG = "Unable to create a Gist in GitHub.";

  /** The Constant GIT_API_URI. */
  public static final String GIT_API_URI = "https://api.github.com";

  /** The Constant REPO_API. */
  public static final String REPO_API =
      "/user/repos"; // To get all repos, also used for creating a repo

  /** The Constant USER_API. */
  public static final String USER_API = "/user"; // To get user details

  /** The Constant GIST_API. */
  public static final String GIST_API = "/users/{0}/gists";

  /** The Constant SEARCH_REPO_API. */
  public static final String SEARCH_REPO_API =
      "/repos/{0}/{1}"; // To search the repo /repos/<loginUser>/<repoName>

  /** The github repo clone uri. */
  public static String GITHUB_REPO_CLONE_URI =
      "https://github.com/{0}/{1}.git"; // "https://github.com/debjava/Hello-World.git"

  /** The Constant GITHUB_GET_GIST_API. */
  public static final String GITHUB_GET_GIST_API = GIT_API_URI + GIST_API;

  /** The Constant GITHUB_CREATE_GIST_API. */
  public static final String GITHUB_CREATE_GIST_API = "/gists";

  /** The Constant BITBUCKET_API_URI. */
  // BitBucket API Details
  public static final String BITBUCKET_API_URI = "https://api.bitbucket.org/2.0";

  /** The Constant BITBUCKET_USER_API_URI. */
  public static final String BITBUCKET_USER_API_URI = "/user";

  /** The Constant BITBUCKET_ALL_REPO_API_URI. */
  public static final String BITBUCKET_ALL_REPO_API_URI = "/repositories/{0}";

  /** The Constant BITBUCKET_EXISTING_REPO_API_URI. */
  public static final String BITBUCKET_EXISTING_REPO_API_URI = "/repositories/{0}/{1}";

  /** The Constant BITBUCKET_CREATE_API_URI. */
  public static final String BITBUCKET_CREATE_API_URI = "/repositories/{0}/{1}";

  /** The Constant BITBUCKET_CLONE_API_URI. */
  // https://sambittechy@bitbucket.org/sambittechy/dd111.git
  public static final String BITBUCKET_CLONE_API_URI = "https://{0}@bitbucket.org/{1}/{2}.git";

  /** The Constant BITBUCKET_GET_OR_CREATE_GIST_API_URI. */
  public static final String BITBUCKET_GET_OR_CREATE_GIST_API_URI = "/snippets/{0}";

  /** The Constant BITBUCKET_SNIPPET_ERR_MSG. */
  // Bitbucket Constants
  public static final String BITBUCKET_SNIPPET_ERR_MSG = "Unable to create a Snippet in Bitbucket.";

  /** The Constant BITBUCKET_CLONE_ERR_MSG. */
  public static final String BITBUCKET_CLONE_ERR_MSG =
      "Unable to clone the project from Bitbucket.";

  /** The Constant BITBUCKET_REPO_ERR_MSG. */
  public static final String BITBUCKET_REPO_ERR_MSG =
      "Unable to create a repo in Bitbucket, a repository may already exist.";
}
