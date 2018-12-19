/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class CommonUtil.
 *
 * @author Debadatta Mishra
 */
public class CommonUtil {

  /** The Constant HOME_DIR. */
  // Product Specific
  public static final String HOME_DIR = System.getProperty("user.home");

  /** The Constant TEMP_GIT_PATH. */
  public static final String TEMP_GIT_PATH = "DDLAB";

  /** The Constant HOME_GIT_PATH. */
  public static final String HOME_GIT_PATH = CommonUtil.getTempGitLocation();

  /** The Constant DATE_PATTERN. */
  public static final String DATE_PATTERN = "dd-MMM-yyyy hh:mm a";

  /** The Constant DATE_FORMAT. */
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN);

  /**
   * Gets the temp git location.
   *
   * @return the temp git location
   */
  public static String getTempGitLocation() {
    File tempGitDir = new File(HOME_DIR + File.separator + TEMP_GIT_PATH);
    if (!tempGitDir.exists()) tempGitDir.mkdirs();
    return tempGitDir.getAbsolutePath();
  }

  /**
   * Gets the today date time.
   *
   * @return the today date time
   */
  public static final String getTodayDateTime() {
    return DATE_FORMAT.format(new Date());
  }
}
