/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IErrorResponseParser;
import com.ddlab.gitpusher.exception.GenericGitPushException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;

/**
 * The Class RepoCreateErrorResponseParser.
 *
 * @author Debadatta Mishra
 */
public class RepoCreateErrorResponseParser implements IErrorResponseParser<String, String> {

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IErrorResponseParser#parseError(java.lang.Object)
   */
  @Override
  public String parseError(String jsonText) throws GenericGitPushException {
    String errorMessage = null;
    try {
      errorMessage = getErrorMessage(jsonText);
    } catch (IOException e) {
      throw new GenericGitPushException(
          "Unable to parse error message coming out of Repo creation in GitHub.");
    }
    return errorMessage;
  }

  /**
   * Gets the error message.
   *
   * @param jsonText the json text
   * @return the error message
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private String getErrorMessage(String jsonText) throws IOException {
    StringBuilder builder = new StringBuilder("");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(jsonText);
    JsonNode errorNode = root.get("errors");
    if (errorNode.isArray()) {
      Iterator<JsonNode> itr = errorNode.iterator();
      while (itr.hasNext()) {
        JsonNode tempNode = itr.next();
        JsonNode msgNode = tempNode.get("message");
        if (msgNode != null) builder.append(msgNode.asText()).append("\n");
      }
    }
    return builder.toString();
  }
}
