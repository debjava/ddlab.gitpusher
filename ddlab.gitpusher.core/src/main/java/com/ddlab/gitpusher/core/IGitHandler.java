/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.core;

import java.io.File;

/**
 * The Interface IGitHandler.
 *
 * @author Debadatta Mishra
 */
public interface IGitHandler {

  /**
   * Gets the user name.
   *
   * @return the user name
   * @throws Exception the exception
   */
  String getUserName() throws Exception;

  /**
   * Gets the all repositories.
   *
   * @return the all repositories
   * @throws Exception the exception
   */
  String[] getAllRepositories() throws Exception;

  /**
   * Repo exists.
   *
   * @param repoName the repo name
   * @return true, if successful
   * @throws Exception the exception
   */
  boolean repoExists(String repoName) throws Exception;

  /**
   * Gets the url from local repsitory.
   *
   * @param gitDirPath the git dir path
   * @return the url from local repsitory
   * @throws Exception the exception
   */
  String getUrlFromLocalRepsitory(File gitDirPath) throws Exception;

  /**
   * Checks if is git dir available.
   *
   * @param gitDirPath the git dir path
   * @return true, if is git dir available
   * @throws Exception the exception
   */
  boolean isGitDirAvailable(File gitDirPath) throws Exception;

  /**
   * Creates the hosted repo.
   *
   * @param repoName the repo name
   * @throws Exception the exception
   */
  void createHostedRepo(String repoName) throws Exception;

  /**
   * Clone.
   *
   * @param repoName the repo name
   * @param dirPath the dir path
   * @throws Exception the exception
   */
  void clone(String repoName, File dirPath) throws Exception;

  /**
   * Update.
   *
   * @param cloneDirPath the clone dir path
   * @param message the message
   * @throws Exception the exception
   */
  void update(File cloneDirPath, String message) throws Exception;

  /**
   * Gets the gists.
   *
   * @return the gists
   * @throws Exception the exception
   */
  String[] getGists() throws Exception;

  /**
   * Creates the gist.
   *
   * @param file the file
   * @param description the description
   * @throws Exception the exception
   */
  void createGist(File file, String description) throws Exception;
}
