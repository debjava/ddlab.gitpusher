/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.core;

/**
 * The Class GitResponse.
 *
 * @author Debadatta Mishra
 */
public class GitResponse {

  /** The status code. */
  private String statusCode;

  /** The response text. */
  private String responseText;

  /**
   * Instantiates a new git response.
   *
   * @param statusCode the status code
   * @param responseText the response text
   */
  public GitResponse(String statusCode, String responseText) {
    this.statusCode = statusCode;
    this.responseText = responseText;
  }

  /**
   * Gets the status code.
   *
   * @return the status code
   */
  public String getStatusCode() {
    return statusCode;
  }

  /**
   * Gets the response text.
   *
   * @return the response text
   */
  public String getResponseText() {
    return responseText;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "GitResponse{"
        + "statusCode='"
        + statusCode
        + '\''
        + ", responseText='"
        + responseText
        + '\''
        + '}';
  }
}
