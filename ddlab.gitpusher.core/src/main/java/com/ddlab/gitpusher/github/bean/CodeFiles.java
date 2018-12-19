/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.github.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class CodeFiles.
 *
 * @author Debadatta Mishra
 */
public class CodeFiles {

  /** The content. */
  @JsonProperty("content")
  private String content;

  /**
   * Gets the content.
   *
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets the content.
   *
   * @param content the new content
   */
  public void setContent(String content) {
    this.content = content;
  }
}
