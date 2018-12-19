/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.core;

import com.ddlab.gitpusher.exception.GenericGitPushException;

/**
 * The Interface IErrorResponseParser.
 *
 * @author Debadatta Mishra
 * @param <IN> the generic type
 * @param <OUT> the generic type
 */
public interface IErrorResponseParser<IN, OUT> {

  /**
   * Parses the error.
   *
   * @param in the in
   * @return the out
   * @throws GenericGitPushException the generic git push exception
   */
  OUT parseError(IN in) throws GenericGitPushException;
}
