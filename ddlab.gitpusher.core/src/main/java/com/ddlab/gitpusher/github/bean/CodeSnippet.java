/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.github.bean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class CodeSnippet.
 *
 * @author Debadatta Mishra
 */
@JsonPropertyOrder({"description", "public", "files"})
public class CodeSnippet {

  /** The description. */
  @JsonProperty("description")
  private String description;

  /** The is public. */
  @JsonProperty("public")
  private boolean isPublic = true;

  /** The files. */
  @JsonProperty("files")
  private Map<String, CodeFiles> files;

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Checks if is public.
   *
   * @return true, if is public
   */
  public boolean isPublic() {
    return isPublic;
  }

  /**
   * Sets the public.
   *
   * @param isPublic the new public
   */
  public void setPublic(boolean isPublic) {
    this.isPublic = isPublic;
  }

  /**
   * Gets the files.
   *
   * @return the files
   */
  public Map<String, CodeFiles> getFiles() {
    return files;
  }

  /**
   * Sets the files.
   *
   * @param files the files
   */
  public void setFiles(Map<String, CodeFiles> files) {
    this.files = files;
  }

  /**
   * To JSON.
   *
   * @return the string
   */
  public String toJSON() {
    ObjectMapper mapper = new ObjectMapper();
    String toJson = null;
    try {
      toJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return toJson;
  }

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    CodeSnippet snippet = new CodeSnippet();
    //    snippet.setPublic(true);
    snippet.setDescription("it is only for testing.");

    CodeFiles codeFile = new CodeFiles();
    //    codeFile.setFileName("test.java");
    codeFile.setContent("System.out.println");
    Map<String, CodeFiles> codeMap = new HashMap<>();
    codeMap.put("test.java", codeFile);

    snippet.setFiles(codeMap);

    System.out.println(snippet.toJSON());
  }
}
