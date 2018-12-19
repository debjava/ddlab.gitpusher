/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.tornado.exceptions;

/**
 * The Class SnippetException.
 *
 * @author Debadatta Mishra
 */
public class SnippetException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -1722640780407606671L;

  /**
   * Instantiates a new snippet exception.
   *
   * @param errorMessage the error message
   */
  public SnippetException(String errorMessage) {
    super(errorMessage);
  }

  /**
   * Instantiates a new snippet exception.
   *
   * @param ex the ex
   */
  public SnippetException(Exception ex) {
    super(ex);
  }

  /* (non-Javadoc)
   * @see java.lang.Throwable#getMessage()
   */
  @Override
  public String getMessage() {
    return super.getMessage();
  }
}
