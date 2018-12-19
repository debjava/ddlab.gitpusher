/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.core;

import com.ddlab.gitpusher.exception.GenericGitPushException;

import java.io.File;

/**
 * The Interface IGitPusher.
 *
 * @author Debadatta Mishra
 */
public interface IGitPusher {

  /**
   * Push code directly.
   *
   * @param projectDir the project dir
   * @throws GenericGitPushException the generic git push exception
   */
  void pushCodeDirectly(File projectDir) throws GenericGitPushException;

  /**
   * Push snippet directly.
   *
   * @param file the file
   * @param description the description
   * @throws GenericGitPushException the generic git push exception
   */
  void pushSnippetDirectly(File file, String description) throws GenericGitPushException;

  /**
   * Gets the existing repos.
   *
   * @return the existing repos
   * @throws GenericGitPushException the generic git push exception
   */
  String[] getExistingRepos() throws GenericGitPushException;

  /**
   * Gets the existing snippets.
   *
   * @return the existing snippets
   * @throws GenericGitPushException the generic git push exception
   */
  String[] getExistingSnippets() throws GenericGitPushException;
}
