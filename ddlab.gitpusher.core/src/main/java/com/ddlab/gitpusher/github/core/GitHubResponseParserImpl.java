/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.github.core;

import com.ddlab.gitpusher.core.IErrorResponseParser;
import com.ddlab.gitpusher.core.IResponseParser;
import com.ddlab.gitpusher.exception.GenericGitPushException;
import com.ddlab.gitpusher.github.bean.GitHubRepo;
import com.ddlab.gitpusher.github.bean.Repo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * The Class GitHubResponseParserImpl.
 *
 * @author Debadatta Mishra
 */
public class GitHubResponseParserImpl implements IResponseParser<String, GitHubRepo> {

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IResponseParser#getAllRepos(java.lang.Object)
   */
  @Override
  public GitHubRepo getAllRepos(String jsonResponse) throws GenericGitPushException {
    GitHubRepo gitRepo = new GitHubRepo();
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    Repo[] repos = null;
    try {
      repos = mapper.readValue(jsonResponse, Repo[].class);
      gitRepo.setRepos(repos);
    } catch (IOException e) {
      e.printStackTrace();
      throw new GenericGitPushException("Unable to parse the json response coming from GitHub");
    }
    return gitRepo;
  }

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IResponseParser#getUser(java.lang.Object)
   */
  @Override
  public GitHubRepo getUser(String jsonResponse) throws GenericGitPushException {
    GitHubRepo gitRepo = new GitHubRepo();
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    try {
      gitRepo = mapper.readValue(jsonResponse, GitHubRepo.class);
    } catch (IOException e) {
      e.printStackTrace();
      throw new GenericGitPushException("Unable to parse the json response coming from GitHub");
    }
    return gitRepo;
  }

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IResponseParser#getNewlyCreatedHostedRepo(java.lang.Object, com.ddlab.gitpusher.core.IErrorResponseParser)
   */
  @Override
  public GitHubRepo getNewlyCreatedHostedRepo(
      String jsonResponse, IErrorResponseParser<String, String> errorParser)
      throws GenericGitPushException {
    GitHubRepo gitRepo = new GitHubRepo();
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    try {
      gitRepo = mapper.readValue(jsonResponse, GitHubRepo.class);
      if (gitRepo.getCloneUrl() == null) {
        String errorMessage = errorParser.parseError(jsonResponse);
        throw new GenericGitPushException(errorMessage);
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new GenericGitPushException("Unable to parse the json response coming from GitHub");
    }
    return gitRepo;
  }

  /* (non-Javadoc)
   * @see com.ddlab.gitpusher.core.IResponseParser#getAllGistSnippets(java.lang.Object)
   */
  @Override
  public GitHubRepo getAllGistSnippets(String s) throws GenericGitPushException {
    return null;
  }
}
