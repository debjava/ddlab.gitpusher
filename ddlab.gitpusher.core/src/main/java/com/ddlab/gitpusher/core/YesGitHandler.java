/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.core;

import java.io.File;

/**
 * The Interface YesGitHandler.
 *
 * @author Debadatta Mishra
 */
public interface YesGitHandler {

  /**
   * Handle.
   *
   * @param projectDir the project dir
   * @param gitHandler the git handler
   * @throws Exception the exception
   */
  void handle(File projectDir, IGitHandler gitHandler) throws Exception;
}
