/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.github.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The Class Repo.
 *
 * @author Debadatta Mishra
 */
public class Repo {

  /** The name. */
  @JsonProperty("name")
  private String name;

  /** The clone url. */
  @JsonProperty("clone_url")
  private String cloneUrl;

  /**
   * Instantiates a new repo.
   *
   * @param name the name
   * @param cloneUrl the clone url
   */
  public Repo(String name, String cloneUrl) {
    this.name = name;
    this.cloneUrl = cloneUrl;
  }

  /** Instantiates a new repo. */
  public Repo() {}

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the clone url.
   *
   * @param cloneUrl the new clone url
   */
  public void setCloneUrl(String cloneUrl) {
    this.cloneUrl = cloneUrl;
  }

  /**
   * Gets the clone url.
   *
   * @return the clone url
   */
  public String getCloneUrl() {
    return cloneUrl;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Repo repo = (Repo) o;
    return Objects.equals(name, repo.name) && Objects.equals(cloneUrl, repo.cloneUrl);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, cloneUrl);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Repo{" + "name='" + name + '\'' + ", cloneUrl='" + cloneUrl + '\'' + '}';
  }
}
