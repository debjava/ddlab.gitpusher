/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.generator;

/**
 * The Interface IReadMeGen.
 *
 * @author Debadatta Mishra
 */
public interface IReadMeGen {

  /**
   * Generate read me md contents.
   *
   * @param projectName the project name
   * @param description the description
   * @param contributorName the contributor name
   * @return the string
   */
  String generateReadMeMdContents(String projectName, String description, String contributorName);
}
