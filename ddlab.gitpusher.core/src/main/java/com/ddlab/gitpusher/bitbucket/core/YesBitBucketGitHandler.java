/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.bitbucket.core;

import java.io.File;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.YesGitHandler;

/**
 * The Class YesBitBucketGitHandler.
 *
 * @author Debadatta Mishra
 */
public class YesBitBucketGitHandler implements YesGitHandler {

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.YesGitHandler#handle(java.io.File, com.ddlab.gitpusher.core.IGitHandler)
   */
  @Override
  public void handle(File projectDir, IGitHandler gitHandler) throws Exception {
    gitHandler.update(projectDir, null);
  }
}
