/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.core;

import com.ddlab.gitpusher.exception.GenericGitPushException;

/**
 * The Interface IResponseParser.
 *
 * @author Debadatta Mishra
 * @param <IN> the generic type
 * @param <OUT> the generic type
 */
public interface IResponseParser<IN, OUT> {

  /**
   * Gets the all repos.
   *
   * @param in the in
   * @return the all repos
   * @throws GenericGitPushException the generic git push exception
   */
  OUT getAllRepos(IN in) throws GenericGitPushException;

  /**
   * Gets the user.
   *
   * @param in the in
   * @return the user
   * @throws GenericGitPushException the generic git push exception
   */
  OUT getUser(IN in) throws GenericGitPushException;

  /**
   * Gets the newly created hosted repo.
   *
   * @param in the in
   * @param errorParser the error parser
   * @return the newly created hosted repo
   * @throws GenericGitPushException the generic git push exception
   */
  OUT getNewlyCreatedHostedRepo(IN in, IErrorResponseParser<String, String> errorParser)
      throws GenericGitPushException;

  /**
   * Gets the all gist snippets.
   *
   * @param in the in
   * @return the all gist snippets
   * @throws GenericGitPushException the generic git push exception
   */
  OUT getAllGistSnippets(IN in) throws GenericGitPushException;
}
