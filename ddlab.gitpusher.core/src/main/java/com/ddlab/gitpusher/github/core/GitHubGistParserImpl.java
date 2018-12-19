/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.github.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ddlab.gitpusher.core.IGistResponseParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class GitHubGistParserImpl.
 *
 * @author Debadatta Mishra
 */
public class GitHubGistParserImpl implements IGistResponseParser<String, String[]> {

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IGistResponseParser#parse(java.lang.Object)
   */
  @Override
  public String[] parse(String jsonResponse) throws Exception {
    List<String> gistList = new ArrayList<String>();
    ObjectMapper mapper = new ObjectMapper();
    try {
      JsonNode rootNode = mapper.readTree(jsonResponse);
      if (rootNode.isArray()) {
        for (JsonNode rootArrNode : rootNode) {
          JsonNode filesNode = rootArrNode.get("files");
          Iterator<JsonNode> jnItr = filesNode.elements();
          while (jnItr.hasNext()) {
            JsonNode jNode = jnItr.next();
            gistList.add(jNode.get("filename").asText());
          }
        }
      } else {
        throw new IOException("Able to connect, but no gist found...");
      }
    } catch (IOException e) {
      throw e;
    }
    return gistList.toArray(new String[0]);
  }
}
