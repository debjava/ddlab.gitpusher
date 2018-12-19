/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.exception;

/**
 * The Class GenericGitPushException.
 *
 * @author Debadatta Mishra
 */
public class GenericGitPushException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 9102128217654596979L;

  /**
   * Instantiates a new generic git push exception.
   *
   * @param errMessage the err message
   */
  public GenericGitPushException(String errMessage) {
    super(errMessage);
  }

  /**
   * Instantiates a new generic git push exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public GenericGitPushException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new generic git push exception.
   *
   * @param ex the ex
   */
  public GenericGitPushException(Exception ex) {
    super(ex);
  }
}
